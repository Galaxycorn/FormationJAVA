package com.eshopJPASpringBoot.demo.exceptions;

public class ReferenceNullException extends RuntimeException {

    public ReferenceNullException() {

    }

    public ReferenceNullException(String message) {
        super(message);
    }
}
