package com.julio.expensesapp.domain.exception;

public class InvalidUserMailException extends UserException{
    public InvalidUserMailException(String message){
        super(message);
    }
}
