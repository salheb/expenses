package com.julio.expensesapp.usecase.expense;

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

    public void delete(UUID uuid){ repository.delete(uuid); }
}
