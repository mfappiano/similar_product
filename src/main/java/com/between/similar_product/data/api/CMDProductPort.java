package com.between.similar_product.data.api;

import com.between.similar_product.data.api.response.ProductDetail;

import java.util.List;

public interface CMDProductPort {

    List<ProductDetail> getSimilarProductDetails(String productId);
}
