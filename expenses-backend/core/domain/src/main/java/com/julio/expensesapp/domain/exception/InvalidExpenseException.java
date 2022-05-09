package com.julio.expensesapp.domain.exception;

public class InvalidExpenseException extends RuntimeException{

    public InvalidExpenseException(final String message){
        super(message);
    }
}
