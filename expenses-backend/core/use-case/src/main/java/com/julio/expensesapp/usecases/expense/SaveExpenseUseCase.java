package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class SaveExpenseUseCase {

    private ExpenseAdapter adapter;

    public SaveExpenseUseCase(ExpenseAdapter adapter){ this.adapter = adapter; }

    public Expense save(Expense expense){ return adapter.save(expense); }
}
