package com.julio.expensesapp.adapter.output.mysql;

import com.julio.expensesapp.adapter.output.mysql.model.ExpenseOccurrenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseOccurrenceRepository extends JpaRepository<ExpenseOccurrenceModel, Long> {

    List<ExpenseOccurrenceModel> findByExpenseId(Long expenseId);

    List<ExpenseOccurrenceModel> findByIdAndDateRealBetween(Long expenseId, LocalDateTime from, LocalDateTime to);

    ExpenseOccurrenceModel findByUUID(UUID UUID);

    ExpenseOccurrenceModel findById(long id);

}
