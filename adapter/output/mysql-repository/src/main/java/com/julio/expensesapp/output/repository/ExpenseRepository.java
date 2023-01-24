package com.julio.expensesapp.output.repository;

import com.julio.expensesapp.output.repository.entity.ExpenseEntity;
import jakarta.enterprise.context.ApplicationScoped;
import org.springframework.data.jpa.repository.JpaRepository;


import jakarta.inject.Named;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Named
@ApplicationScoped
@Deprecated
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findAll();

    List<ExpenseEntity> findByDate(ZonedDateTime date);

    List<ExpenseEntity> findByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    ExpenseEntity findByUUID(UUID uuid);

    ExpenseEntity findById(long id);

    ExpenseEntity save(ExpenseEntity expense);
}