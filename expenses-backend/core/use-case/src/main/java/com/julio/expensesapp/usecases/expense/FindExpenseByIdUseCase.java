package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class FindExpenseByIdUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByIdUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public Expense find(long id){
        return adapter.findExpenseById(id);
    }
    
    
}