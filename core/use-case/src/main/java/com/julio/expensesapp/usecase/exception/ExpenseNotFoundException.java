package com.julio.expensesapp.usecase.exception;

import com.julio.expensesapp.domain.exception.ExpenseException;

public class ExpenseNotFoundException extends ExpenseException {
    public ExpenseNotFoundException(final String message) {
        super(message);
    }
}
