package com.between.similar_product.data.api.impl;

import com.between.similar_product.data.api.CMDProductPort;
import com.between.similar_product.data.api.CMDProductRestClient;
import com.between.similar_product.data.api.response.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.between.similar_product.data.api.helper.RestHandlerHelper.executeCallWithBody;

@Component
public class CMDProductPortAdapter implements CMDProductPort {

    private final CMDProductRestClient cmdProductRestClient;

    @Autowired
    public CMDProductPortAdapter(CMDProductRestClient cmdProductRestClient) {
        this.cmdProductRestClient = cmdProductRestClient;
    }

    @Override
    public List<ProductDetail> getSimilarProductDetails(String productId) {
        final List<String> similarProducts = executeCallWithBody(
                this.cmdProductRestClient.getSimilarProductDetailsById(productId));

        List<CompletableFuture<ProductDetail>> futures = similarProducts.stream()
                .map(this::callProductApiById)
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        return allOf.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        ).join();
    }

    private CompletableFuture<ProductDetail> callProductApiById(String productId) {
        return CompletableFuture.supplyAsync(() ->
                executeCallWithBody(
                        cmdProductRestClient.getProductById(productId))
        );
    }
}
