package com.julio.expensesapp.domain.exception;

public class UserException extends RuntimeException{
    public UserException(final String message){
        super(message);
    }
}
