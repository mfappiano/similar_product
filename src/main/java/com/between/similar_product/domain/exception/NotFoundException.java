package com.between.similar_product.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String msn) {
        super(msn);
    }

    public NotFoundException(String msn, Throwable reason) {
        super(msn, reason);
    }
}
