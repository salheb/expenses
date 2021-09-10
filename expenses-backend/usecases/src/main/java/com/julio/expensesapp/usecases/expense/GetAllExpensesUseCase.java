package com.julio.expensesapp.usecases.expense;

import java.util.Collection;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class GetAllExpensesUseCase {

    private ExpenseAdapter adapter;

    public GetAllExpensesUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public Collection<Expense> get(){
        return adapter.getAllExpenses();
    }
    
}