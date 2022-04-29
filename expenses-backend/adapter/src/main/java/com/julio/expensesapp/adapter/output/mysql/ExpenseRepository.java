package com.julio.expensesapp.adapter.output.mysql;

import com.julio.expensesapp.adapter.output.mysql.model.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findAll();

    List<ExpenseEntity> findByDate(ZonedDateTime date);

    List<ExpenseEntity> findByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    ExpenseEntity findByUUID(UUID uuid);

    ExpenseEntity findById(long id);

    ExpenseEntity save(ExpenseEntity expense);
}