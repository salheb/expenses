package com.julio.expensesapp.usecases.expenseocurrence;

import java.time.LocalDateTime;
import java.util.Collection;

import com.julio.expensesapp.entities.ExpenseOcurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOcurrenceAdapter;

public class FindOcurrencesByIdUseCase {

    private ExpenseOcurrenceAdapter adapter;

    public FindOcurrencesByIdUseCase(ExpenseOcurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public Collection<ExpenseOcurrence> find(long id ,LocalDateTime date){
        return adapter.findOcurrencesById(id, date);
    }
    
}