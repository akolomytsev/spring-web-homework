package com.geekbrains.spring.web.cart.exeptions;

public class ProductServiceIntegrationException extends RuntimeException {
    public ProductServiceIntegrationException(String message) {
        super(message);
    }
}
