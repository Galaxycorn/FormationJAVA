package com.eshopJPASpringBoot.demo.exceptions;

public class ProduitException extends RuntimeException {

    public ProduitException() {

    }

    public ProduitException(String message) {
        super(message);
    }
}
