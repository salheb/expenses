package com.julio.expensesapp.domain.exception;

public class InvalidExpenseOccurrenceException extends RuntimeException{
    public InvalidExpenseOccurrenceException(final String message){
        super(message);
    }
}
