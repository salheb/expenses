package com.julio.expensesapp.usecase.expenseoccurrence;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecase.port.ExpenseOccurrenceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FindOccurrenceByIdUseCase {

    private ExpenseOccurrenceRepository repository;

    @Inject
    FindOccurrenceByIdUseCase(final ExpenseOccurrenceRepository repository){
        this.repository = repository;
    }

    public ExpenseOccurrence find(long id ){
        return repository.findOccurrenceById(id);
    }
    
}