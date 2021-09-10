package com.julio.expensesapp.usecases.adapter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import com.julio.expensesapp.entities.ExpenseOcurrence;

public interface ExpenseOcurrenceAdapter {

    Collection<ExpenseOcurrence> findOcurrencesById(long id ,LocalDateTime date);

    Collection<ExpenseOcurrence> findOcurrencesByUuid(UUID uuid, LocalDateTime date);
    
}