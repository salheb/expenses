package com.julio.expensesapp.usecases.expense;

import java.time.LocalDateTime;
import java.util.Collection;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class FindExpenseByDate {

    private ExpenseAdapter adapter;

    public FindExpenseByDate(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public Collection<Expense> find(LocalDateTime date){
        return adapter.findExpenseByDate(date);
    }
}