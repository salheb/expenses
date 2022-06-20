package com.julio.expensesapp.domain.exception;

public class InvalidExpenseValueException extends ExpenseException{
    public InvalidExpenseValueException(final String message){
        super(message);
    }
}
