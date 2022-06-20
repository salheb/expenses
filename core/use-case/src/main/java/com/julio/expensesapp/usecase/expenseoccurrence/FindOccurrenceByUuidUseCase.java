package com.julio.expensesapp.usecase.expenseoccurrence;

import java.util.UUID;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecase.port.ExpenseOccurrenceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindOccurrenceByUuidUseCase {

    private final ExpenseOccurrenceRepository repository;

    @Inject
    public FindOccurrenceByUuidUseCase(final ExpenseOccurrenceRepository repository){
        this.repository = repository;
    }

    public ExpenseOccurrence find(UUID uuid){
        return repository.findOccurrenceByUUID(uuid);
    }
    
}