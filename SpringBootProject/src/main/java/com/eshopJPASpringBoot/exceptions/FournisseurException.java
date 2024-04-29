package com.eshopJPASpringBoot.exceptions;

public class FournisseurException  extends RuntimeException  {
    public FournisseurException(){

    }

    public FournisseurException(String message){
        super(message);
    }
}
