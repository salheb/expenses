package com.julio.expensesapp.usecase.expense;

import java.util.UUID;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindExpenseByUUIDUseCase {
    private final ExpenseRepository repository;

    @Inject
    FindExpenseByUUIDUseCase(final ExpenseRepository repository){
        this.repository = repository;
    }

    public Expense find(UUID uuid){
        return repository.findExpenseByUUID(uuid);
    }
    
}