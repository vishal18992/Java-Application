package com.exception;

public class AccountNotFoundException extends  Exception{
    public AccountNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
