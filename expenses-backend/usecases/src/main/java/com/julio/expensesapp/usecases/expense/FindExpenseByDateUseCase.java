package com.julio.expensesapp.usecases.expense;

import java.time.LocalDateTime;
import java.util.List;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class FindExpenseByDateUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByDateUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(LocalDateTime date){
        return adapter.findExpenseByDate(date);
    }
}