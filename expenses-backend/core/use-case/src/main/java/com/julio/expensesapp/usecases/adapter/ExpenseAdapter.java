package com.julio.expensesapp.usecases.adapter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.julio.expensesapp.domain.Expense;

public interface ExpenseAdapter {

    List<Expense> findAll();

    Expense findExpenseById(long id);

    Expense findExpenseByUUID(UUID uuid);

    List<Expense> findExpenseByDate(ZonedDateTime date);

    List<Expense> findExpenseByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    Expense save(Expense expense);

    void delete(UUID uuid);
    
}