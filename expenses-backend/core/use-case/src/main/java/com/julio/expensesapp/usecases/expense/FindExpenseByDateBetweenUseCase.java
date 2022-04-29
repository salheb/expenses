package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FindExpenseByDateBetweenUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByDateBetweenUseCase(ExpenseAdapter adapter){
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
