package com.julio.expensesapp.output.repository;
import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.output.repository.entity.ExpenseEntity;
import com.julio.expensesapp.output.repository.entity.ExpenseEntityRepository;
import com.julio.expensesapp.output.repository.mapper.ExpenseMapper;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Named
@ApplicationScoped
public class ExpenseGateway implements ExpenseRepository {
    private final ExpenseEntityRepository repository;
    private final ExpenseMapper mapper;

    @Inject
    ExpenseGateway(final ExpenseEntityRepository repository,
                   final ExpenseMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Expense> findAll(final long userId) {
        return mapper.toDomain(repository.findAll(userId));
    }

    @Override
    public Optional<Expense> findExpenseById(final long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Expense> findExpenseByUUID(UUID uuid) {
        return repository.findByUUID(uuid).map(mapper::toDomain);
    }

    @Override
    public List<Expense> findExpenseByDate(ZonedDateTime date) {
        return mapper.toDomain(repository.findByDate(date));
    }

    @Override
    public List<Expense> findExpenseByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        return mapper.toDomain(repository.findByDateBetween(dateFrom, dateTo));
    }

    @Override
    public Expense save(Expense expense) {
        // TODO: check if this code is useful, don't understand why should I return something here
        ExpenseEntity expenseEntity = mapper.toEntity(expense);
        repository.save(expenseEntity);
        return mapper.toDomain(expenseEntity);
    }

    @Override
    public void delete(UUID uuid) {
        repository.delete(uuid);
    }

    @Override
    public boolean exists(UUID uuid) {
        return repository.exists(uuid);
    }
}
