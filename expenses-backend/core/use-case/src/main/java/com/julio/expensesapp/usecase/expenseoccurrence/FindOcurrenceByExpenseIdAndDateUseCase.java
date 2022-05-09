package com.julio.expensesapp.usecase.expenseoccurrence;

import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.usecase.port.ExpenseOccurrenceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.List;

@Named
@ApplicationScoped
public class FindOcurrenceByExpenseIdAndDateUseCase {
    private final ExpenseOccurrenceRepository repository;

    @Inject
    FindOcurrenceByExpenseIdAndDateUseCase(final ExpenseOccurrenceRepository repository){
        this.repository = repository;
    }

    public List<ExpenseOccurrence> find(long id, LocalDateTime from, LocalDateTime to){
        return repository.findByIdAndDateRealBetween(id, from, to);
    }
}
