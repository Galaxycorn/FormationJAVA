package com.eshopJPASpringBoot.exceptions;

public class CategorieException extends RuntimeException {
    public CategorieException(){

    }
    public CategorieException(String msg){
        super(msg);
    }

}
