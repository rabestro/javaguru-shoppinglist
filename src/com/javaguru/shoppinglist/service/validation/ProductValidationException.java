package com.javaguru.shoppinglist.service.validation;

public class ProductValidationException extends Exception {

    public ProductValidationException() {
    }

    public ProductValidationException(String message) {
        super(message);
    }
}
