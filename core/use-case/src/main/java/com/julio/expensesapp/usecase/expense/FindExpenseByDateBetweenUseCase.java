package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.ZonedDateTime;
import java.util.List;

@Named
@ApplicationScoped
public class FindExpenseByDateBetweenUseCase {

    private final ExpenseRepository adapter;

    @Inject
    FindExpenseByDateBetweenUseCase(final ExpenseRepository adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(ZonedDateTime dateFrom, ZonedDateTime dateTo){
        return adapter.findExpenseByDateBetween(dateFrom, dateTo);
    }
}
