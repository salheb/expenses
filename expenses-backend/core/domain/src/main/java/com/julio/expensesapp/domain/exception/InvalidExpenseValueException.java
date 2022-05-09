package com.julio.expensesapp.domain.exception;

public class InvalidExpenseValueException extends InvalidExpenseException{
    public InvalidExpenseValueException(final String message){
        super(message);
    }
}
