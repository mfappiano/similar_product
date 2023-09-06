package com.between.similar_product.infrastructure.web.mapper;

import com.between.similar_product.data.api.response.ProductDetail;
import com.between.similar_product.infrastructure.web.dto.ProductDetailDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDetailsMapper {

    public List<ProductDetailDTO> mapListBtoA(List<ProductDetail> productDetails) {
        return productDetails.stream()
                .map(this::mapBtoA)
                .collect(Collectors.toList());
    }

    public ProductDetailDTO mapBtoA(ProductDetail price) {
        Optional<ProductDetailDTO> element = Optional
                .ofNullable(price)
                .map(domainObj -> ProductDetailDTO.builder()
                        .id(domainObj.getId())
                        .name(domainObj.getName())
                        .price(domainObj.getPrice())
                        .availability(domainObj.getAvailability())
                        .build());
        return element.orElseGet(() -> ProductDetailDTO.builder().build());
    }

}
