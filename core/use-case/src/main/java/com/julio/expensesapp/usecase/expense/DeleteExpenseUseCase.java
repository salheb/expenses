package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.usecase.exception.ExpenseNotFoundException;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class DeleteExpenseUseCase {
    private final ExpenseRepository repository;

    @Inject
    DeleteExpenseUseCase(final ExpenseRepository repository){ this.repository = repository; }

    public void delete(UUID uuid){
        if (repository.exists(uuid))
            repository.delete(uuid);
        else
            throw new ExpenseNotFoundException("The expense record with unique id " + uuid + " does not exist.");
    }
}
