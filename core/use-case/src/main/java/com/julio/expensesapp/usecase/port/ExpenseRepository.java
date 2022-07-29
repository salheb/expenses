package com.julio.expensesapp.usecase.port;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.julio.expensesapp.domain.Expense;

public interface ExpenseRepository {

    List<Expense> findAll(long userId);

    Optional<Expense> findExpenseById(long id);

    Optional<Expense> findExpenseByUUID(UUID uuid);

    List<Expense> findExpenseByDate(ZonedDateTime date);

    List<Expense> findExpenseByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    Expense save(Expense expense);

    void delete(UUID uuid);

    boolean exists(UUID uuid);
    
}