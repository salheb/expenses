package com.julio.expensesapp.usecase.expense;

import java.time.ZonedDateTime;
import java.util.List;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindExpenseByDateUseCase {

    private final ExpenseRepository repository;

    @Inject
    FindExpenseByDateUseCase(final ExpenseRepository repository){
        this.repository = repository;
    }

    public List<Expense> find(ZonedDateTime date){
        return repository.findExpenseByDate(date);
    }
}