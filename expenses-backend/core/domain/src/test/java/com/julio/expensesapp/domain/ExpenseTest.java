package com.julio.expensesapp.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseTest {
    private Expense expense;
    private ExpenseOccurrence occurrence;

    @Test
    void createNewExpenseTest(){
        expense = Expense.builder()
                .id(1)
                .uuid(UUID.randomUUID())
                .expenseType(1)
                .expenseDescription("Morning breakfast at Danny's")
                .value(BigDecimal.valueOf(29.90))
                .date(LocalDateTime.now())
                .recurrence(0)
                .beWarned(true)
                .build();

        occurrence = ExpenseOccurrence.builder()
                .expenseId(expense.getId())
                .valueReal(expense.getValue())
                .dateReal(expense.getDate())
                .id(1)
                .uuid(UUID.randomUUID())
                .build();

        Assertions.assertNotNull(expense);
        Assertions.assertNotNull(occurrence);
    }
}
