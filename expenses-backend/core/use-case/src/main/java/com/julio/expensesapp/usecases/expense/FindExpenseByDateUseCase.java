package com.julio.expensesapp.usecases.expense;

import java.time.ZonedDateTime;
import java.util.List;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class FindExpenseByDateUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByDateUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(ZonedDateTime date){
        return adapter.findExpenseByDate(date);
    }
}