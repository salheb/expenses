package com.julio.expensesapp.usecase.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
        List<Expense> response = adapter.findExpenseByDateBetween(dateFrom, dateTo);
        System.out.println("Conteúdo da lista no usecase: " + response);
        return response;
    }

    public List<Expense> find(String dateFrom, String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ZonedDateTime dateTimeFrom = ZonedDateTime.parse(dateFrom);
        ZonedDateTime dateTimeTo = ZonedDateTime.parse(dateTo);

        List<Expense> response = adapter.findExpenseByDateBetween(dateTimeFrom, dateTimeTo);
        System.out.println("Conteúdo da lista no usecase: " + response);
        return response;
    }
}
