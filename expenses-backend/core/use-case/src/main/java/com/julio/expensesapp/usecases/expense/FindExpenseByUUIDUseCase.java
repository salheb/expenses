package com.julio.expensesapp.usecases.expense;

import java.util.UUID;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class FindExpenseByUUIDUseCase {
    private ExpenseAdapter adapter;

    public FindExpenseByUUIDUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public Expense find(UUID uuid){
        return adapter.findExpenseByUUID(uuid);
    }
    
}