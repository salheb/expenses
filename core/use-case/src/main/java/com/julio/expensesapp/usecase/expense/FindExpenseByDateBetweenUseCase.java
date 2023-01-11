package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class FindExpenseByDateBetweenUseCase {

    private final ExpenseRepository adapter;

    @Inject
    FindExpenseByDateBetweenUseCase(final ExpenseRepository adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(String dateFrom, String dateTo) throws DateTimeParseException{
        ZonedDateTime zonedDateFrom = ZonedDateTime.parse(dateFrom);
        ZonedDateTime zonedDateTo = ZonedDateTime.parse(dateTo);
        return adapter.findExpenseByDateBetween(zonedDateFrom, zonedDateTo);
    }
}
