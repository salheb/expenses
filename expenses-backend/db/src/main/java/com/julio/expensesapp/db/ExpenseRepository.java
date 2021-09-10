package com.julio.expensesapp.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import com.julio.expensesapp.db.model.ExpenseModel;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {

    Collection<ExpenseModel> getAllExpenses();

    Collection<ExpenseModel> findByDate(LocalDateTime date);

    ExpenseModel findByid(Long id);

    ExpenseModel findByUUID(UUID uuid);
}