package com.julio.expensesapp.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpenseOccurrenceTest {

    private Expense expense;
    private ExpenseOccurrence occurrence;

    @Test
    void shouldReturnValuesWhenExpenseOccurrenceWasCreated(){
        var now = LocalDateTime.now();
        expense = Expense.builder()
                .id(1)
                .uuid(UUID.randomUUID())
                .expenseType(1)
                .expenseDescription("Morning breakfast at Danny's")
                .value(BigDecimal.valueOf(29.90))
                .date(now)
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

        assertThat(occurrence.getExpenseId()).isEqualTo(1);
        assertThat(occurrence.getValueReal()).isEqualTo(BigDecimal.valueOf(29.90));
        assertThat(occurrence.getDateReal()).isEqualTo(now);
    }

    @Test
    void shouldThrowInvalidExpenseOccurrenceException(){
        var now = LocalDateTime.now();
        var builder = ExpenseOccurrence.builder()
                .expenseId(1)
                .valueReal(BigDecimal.valueOf(0))
                .dateReal(now)
                .id(1)
                .uuid(UUID.randomUUID());

        assertThatThrownBy(() -> builder.build()).hasMessage("An occurrence of an expense must have a value.");
    }

    @Test
    void shouldThrowNullPointerException(){
        var now = LocalDateTime.now();
        var builder = ExpenseOccurrence.builder()
                .expenseId(1)
                .valueReal(BigDecimal.valueOf(29.90))
                .id(1)
                .uuid(UUID.randomUUID());

        assertThatThrownBy(() -> builder.build()).hasMessage("Expense Date can't be null.");
    }
}
