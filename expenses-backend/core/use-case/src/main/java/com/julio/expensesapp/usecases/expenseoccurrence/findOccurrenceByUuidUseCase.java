package com.julio.expensesapp.usecases.expenseoccurrence;

import java.util.UUID;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOccurrenceAdapter;

public class findOccurrenceByUuidUseCase {

    private ExpenseOccurrenceAdapter adapter;

    public findOccurrenceByUuidUseCase(ExpenseOccurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public ExpenseOccurrence find(UUID uuid){
        return adapter.findOccurrenceByUUID(uuid);
    }
    
}