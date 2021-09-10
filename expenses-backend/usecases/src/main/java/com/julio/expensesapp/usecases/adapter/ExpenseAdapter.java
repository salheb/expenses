package com.julio.expensesapp.usecases.adapter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import com.julio.expensesapp.entities.Expense;

public interface ExpenseAdapter {

    Collection<Expense> getAllExpenses();

    Expense findExpenseById(long id);

    Expense findExpenseByUUID(UUID uuid);

    Collection<Expense> findExpenseByDate(LocalDateTime date);
    
}