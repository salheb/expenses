package com.julio.expensesapp.domain.exception;

public class InvalidExpenseOccurrenceException extends ExpenseException{
    public InvalidExpenseOccurrenceException(final String message){
        super(message);
    }
}
