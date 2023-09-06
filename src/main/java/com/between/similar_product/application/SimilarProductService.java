package com.between.similar_product.application;

import com.between.similar_product.data.api.response.ProductDetail;

import java.util.List;

public interface SimilarProductService {

    List<ProductDetail> fetchProductDetails(String productId);
}
