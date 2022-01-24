package com.julio.expensesapp.usecases.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.julio.expensesapp.entities.Expense;

public interface ExpenseAdapter {

    List<Expense> findAll();

    Expense findExpenseById(long id);

    Expense findExpenseByUUID(UUID uuid);

    List<Expense> findExpenseByDate(LocalDateTime date);

    List<Expense> findExpenseByDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

    Expense save(Expense expense);

    void delete(UUID uuid);
    
}