package com.julio.expensesapp.usecase.expenseoccurrence;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecase.port.ExpenseOccurrenceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class FindOccurrenceByExpenseIdUseCase {

    private ExpenseOccurrenceRepository repository;

    @Inject
    FindOccurrenceByExpenseIdUseCase(final ExpenseOccurrenceRepository repository){
        this.repository = repository;
    }

    public List<ExpenseOccurrence> find(long id){
        return repository.findOccurrenceByExpenseId(id);
    }
}
