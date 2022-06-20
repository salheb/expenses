package com.julio.expensesapp.domain.exception;

public class ExpenseException extends RuntimeException{
    public ExpenseException(final String message){
        super(message);
    }
}
