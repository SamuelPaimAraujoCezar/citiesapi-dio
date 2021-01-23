package com.github.samuelpacezar.citiesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
    public NotFoundException(Long id, String o) {
        super(o + " not found with ID " + id);
    }
}
