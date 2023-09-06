package com.between.similar_product.infrastructure.web;

import com.between.similar_product.application.SimilarProductService;
import com.between.similar_product.infrastructure.web.dto.ProductDetailDTO;
import com.between.similar_product.infrastructure.web.mapper.ProductDetailsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@ControllerAdvice
@RequestMapping(value = "/product")
public class SimilarProductController {

    private final SimilarProductService similarProductService;
    private final ProductDetailsMapper mapper;

    @Autowired
    public SimilarProductController(SimilarProductService similarProductService,
                                    ProductDetailsMapper mapper) {
        this.similarProductService = similarProductService;
        this.mapper = mapper;
    }

    @GetMapping("/{productId}/similar")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDetailDTO> fetchSimilarProductDetails(@PathVariable String productId) {
        return mapper.mapListBtoA(similarProductService.fetchProductDetails(productId));
    }
}
