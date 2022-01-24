package com.julio.expensesapp.adapter.db;

import com.julio.expensesapp.adapter.db.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {

    List<ExpenseModel> findAll();

    List<ExpenseModel> findByDate(LocalDateTime date);

    List<ExpenseModel> findByDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

    ExpenseModel findByUUID(UUID uuid);

    ExpenseModel findById(long id);

    ExpenseModel save(ExpenseModel expense);
}