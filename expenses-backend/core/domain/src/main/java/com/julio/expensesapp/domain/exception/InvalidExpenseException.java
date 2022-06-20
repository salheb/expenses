package com.julio.expensesapp.domain.exception;

public class InvalidExpenseException extends ExpenseException{

    public InvalidExpenseException(final String message){
        super(message);
    }
}
