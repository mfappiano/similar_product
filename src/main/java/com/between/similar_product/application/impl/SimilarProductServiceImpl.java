package com.between.similar_product.application.impl;

import com.between.similar_product.application.SimilarProductService;
import com.between.similar_product.data.api.CMDProductPort;
import com.between.similar_product.data.api.response.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimilarProductServiceImpl implements SimilarProductService {

    private final CMDProductPort cmdProductPort;

    @Autowired
    public SimilarProductServiceImpl(CMDProductPort cmdProductPort) {
        this.cmdProductPort = cmdProductPort;
    }

    @Override
    public List<ProductDetail> fetchProductDetails(String productId) {
        return cmdProductPort.getSimilarProductDetails(productId);
    }
}
