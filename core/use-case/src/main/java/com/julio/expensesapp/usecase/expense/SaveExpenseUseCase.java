package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.exception.ExpenseNotFoundException;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class SaveExpenseUseCase {
    private final ExpenseRepository repository;

    @Inject
    SaveExpenseUseCase(final ExpenseRepository repository){ this.repository = repository; }

    public Expense save(Expense expense){
        return repository.save(expense);
    }
}
