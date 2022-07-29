package com.julio.expensesapp.usecase.expense;

import java.util.List;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class GetAllExpensesUseCase {

    private final ExpenseRepository repository;

    @Inject
    GetAllExpensesUseCase(final ExpenseRepository repository){
        this.repository = repository;
    }

    public List<Expense> get(long userId){
        return repository.findAll(userId);
    }
    
}