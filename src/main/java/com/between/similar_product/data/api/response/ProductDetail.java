package com.between.similar_product.data.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class ProductDetail {
    String id;
    String name;
    Double price;
    Boolean availability;
}
