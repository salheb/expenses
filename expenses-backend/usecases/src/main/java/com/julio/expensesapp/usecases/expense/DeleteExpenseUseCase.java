package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

import java.util.UUID;

public class DeleteExpenseUseCase {
    private ExpenseAdapter adapter;

    public DeleteExpenseUseCase(ExpenseAdapter adapter){ this.adapter = adapter; }

    public void delete(UUID uuid){ adapter.delete(uuid); }
}
