package com.julio.expensesapp.usecases.expenseocurrence;

import java.time.LocalDateTime;
import java.util.Collection;

import com.julio.expensesapp.entities.ExpenseOcurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOcurrenceAdapter;

public class findOcurrencesByUuidUseCase {

    private ExpenseOcurrenceAdapter adapter;

    public findOcurrencesByUuidUseCase(ExpenseOcurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public Collection<ExpenseOcurrence> find(long uuid ,LocalDateTime date){
        return adapter.findOcurrencesById(uuid, date);
    }
    
}