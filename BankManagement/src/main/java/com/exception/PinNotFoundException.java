package com.exception;

public class PinNotFoundException extends Exception{
    public PinNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
