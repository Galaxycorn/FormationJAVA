package com.eshopJPASpringBoot.demo.exceptions;

public class ClientException extends RuntimeException {

    public ClientException() {

    }

    public ClientException(String message) {
        super(message);
    }
}
