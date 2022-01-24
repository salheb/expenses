package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FindExpenseByDateBetweenUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByDateBetweenUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(LocalDateTime dateFrom, LocalDateTime dateTo){
        List<Expense> response = adapter.findExpenseByDateBetween(dateFrom, dateTo);
        System.out.println("Conteúdo da lista no usecase: " + response);
        return response;
    }

    public List<Expense> find(String dateFrom, String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime dateTimeFrom;
        LocalDateTime dateTimeTo;

        try {
            dateTimeFrom = LocalDate.parse(dateFrom, formatter).atStartOfDay();
            if (dateTo != null)
                dateTimeTo = LocalDate.parse(dateTo, formatter).atTime(LocalTime.MAX);
            else
                dateTimeTo = LocalDate.parse(dateFrom, formatter).atTime(LocalTime.MAX);
        } catch (DateTimeParseException e) {
            dateTimeFrom = LocalDate.now().atStartOfDay().minusDays(30);
            dateTimeTo = LocalDate.now().atTime(LocalTime.MAX);
        }


        List<Expense> response = adapter.findExpenseByDateBetween(dateTimeFrom, dateTimeTo);
        System.out.println("Conteúdo da lista no usecase: " + response);
        return response;
    }
}
