package com.taller.dos.products.commands.infrastructure.exceptions;

public class ProductDuplicatedException extends RuntimeException {
    public ProductDuplicatedException(String message) {
        super(message);
    }

}
