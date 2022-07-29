package com.julio.expensesapp.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpenseOccurrenceTest {

    private Expense expense;
    private ExpenseOccurrence occurrence;

    @Test
    void shouldReturnValuesWhenExpenseOccurrenceWasCreated(){
        var now = ZonedDateTime.now();
        expense = Expense.builder()
                .id(1)
                .uuid(UUID.randomUUID())
                .expenseType(1)
                .expenseDescription("Morning breakfast at Danny's")
                .value(BigDecimal.valueOf(29.90))
                .date(now)
                .recurrence(0)
                .beWarned(true)
                .user(User.builder()
                        .id(1)
                        .authMethod(AuthMethod.GOOGLE)
                        .mail("julio.salheb@gmail.com")
                        .token("random token")
                        .tokenUpdatedAt(now)
                        .build())
                .build();


        occurrence = ExpenseOccurrence.builder()
                .valueReal(expense.getValue())
                .dateReal(expense.getDate())
                .id(1)
                .uuid(UUID.randomUUID())
                .build();

        assertThat(occurrence.getValueReal()).isEqualTo(BigDecimal.valueOf(29.90));
        assertThat(occurrence.getDateReal()).isEqualTo(now);
    }

    @Test
    void shouldThrowInvalidExpenseOccurrenceException(){
        var now = ZonedDateTime.now();
        var builder = ExpenseOccurrence.builder()
                .valueReal(BigDecimal.valueOf(0))
                .dateReal(now)
                .id(1)
                .uuid(UUID.randomUUID());

        assertThatThrownBy(() -> builder.build()).hasMessage("An occurrence of an expense must have a value.");
    }

    @Test
    void shouldThrowNullPointerException(){
        var builder = ExpenseOccurrence.builder()
                .valueReal(BigDecimal.valueOf(29.90))
                .id(1)
                .dateReal(null)
                .uuid(UUID.randomUUID());

        assertThatThrownBy(() -> builder.build()).hasMessage("Expense Date can't be null.");
    }
}
