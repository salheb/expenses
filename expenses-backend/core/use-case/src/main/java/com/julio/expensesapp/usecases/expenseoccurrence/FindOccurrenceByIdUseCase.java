package com.julio.expensesapp.usecases.expenseoccurrence;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOccurrenceAdapter;

public class FindOccurrenceByIdUseCase {

    private ExpenseOccurrenceAdapter adapter;

    public FindOccurrenceByIdUseCase(ExpenseOccurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public ExpenseOccurrence find(long id ){
        return adapter.findOccurrenceById(id);
    }
    
}