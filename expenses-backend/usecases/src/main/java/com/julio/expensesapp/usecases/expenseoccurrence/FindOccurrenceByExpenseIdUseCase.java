package com.julio.expensesapp.usecases.expenseoccurrence;

import com.julio.expensesapp.entities.ExpenseOccurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOccurrenceAdapter;

import java.util.List;

public class FindOccurrenceByExpenseIdUseCase {

    private ExpenseOccurrenceAdapter adapter;

    public FindOccurrenceByExpenseIdUseCase(ExpenseOccurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public List<ExpenseOccurrence> find(long id){
        return adapter.findOccurrenceByExpenseId(id);
    }
}
