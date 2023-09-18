package com.management.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundExepcion extends ResponseStatusException {
    public NotFoundExepcion(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}


