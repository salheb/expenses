package com.julio.expensesapp.usecase.port;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.julio.expensesapp.domain.ExpenseOccurrence;

public interface ExpenseOccurrenceRepository {

    ExpenseOccurrence findOccurrenceById(long id);

    ExpenseOccurrence findOccurrenceByUUID(UUID uuid);

    List<ExpenseOccurrence> findOccurrenceByExpenseId(long id);
    List<ExpenseOccurrence> findByIdAndDateRealBetween(long id, LocalDateTime from, LocalDateTime to);
    
}