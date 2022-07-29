package com.julio.expensesapp.domain.exception;

public class InvalidUserAuthMethodException extends UserException{
    public InvalidUserAuthMethodException(String message){
        super(message);
    }
}
