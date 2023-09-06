package com.between.similar_product.data.api;

import com.between.similar_product.data.api.response.ProductDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface CMDProductRestClient {

    @GET("/product/{productId}/similarids")
    Call<List<String>> getSimilarProductDetailsById(@Path("productId") String productId);

    @GET("/product/{productId}")
    Call<ProductDetail> getProductById(@Path("productId") String productId);

}
