package com.between.similar_product.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    String id;
    String name;
    Double price;
    Boolean availability;
}
