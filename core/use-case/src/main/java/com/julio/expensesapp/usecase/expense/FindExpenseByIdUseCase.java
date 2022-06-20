package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindExpenseByIdUseCase {

    private final ExpenseRepository repository;

    @Inject
    FindExpenseByIdUseCase(final ExpenseRepository repository){
        this.repository = repository;
    }

    public Expense find(long id){
        return repository.findExpenseById(id);
    }
    
    
}