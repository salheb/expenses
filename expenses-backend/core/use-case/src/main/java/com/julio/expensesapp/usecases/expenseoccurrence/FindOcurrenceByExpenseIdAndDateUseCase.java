package com.julio.expensesapp.usecases.expenseoccurrence;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecases.adapter.ExpenseOccurrenceAdapter;

import java.time.LocalDateTime;
import java.util.List;

public class FindOcurrenceByExpenseIdAndDateUseCase {
    private ExpenseOccurrenceAdapter adapter;

    public FindOcurrenceByExpenseIdAndDateUseCase(ExpenseOccurrenceAdapter adapter){
        this.adapter = adapter;
    }

    public List<ExpenseOccurrence> find(long id, LocalDateTime from, LocalDateTime to){
        return adapter.findByIdAndDateRealBetween(id, from, to);
    }
}
