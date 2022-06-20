package com.julio.expensesapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import com.julio.expensesapp.domain.exception.InvalidExpenseException;
import com.julio.expensesapp.domain.exception.InvalidExpenseValueException;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Expense {
    
    private final long id;
    private final UUID uuid;
	private final String expenseDescription;
	private final int expenseType;
    private final BigDecimal value;
    private final LocalDateTime date;
    private final int recurrence;
    private final boolean beWarned;
    private final Collection<ExpenseOccurrence> occurrences;

    @Builder
    Expense(long id,
            UUID uuid,
            String expenseDescription,
            int expenseType,
            BigDecimal value,
            LocalDateTime date,
            int recurrence,
            boolean beWarned,
            Collection<ExpenseOccurrence> occurrences){

        Objects.requireNonNull(date, "Expense Date can't be null.");
        if (value.doubleValue() <= 0)
            throw new InvalidExpenseValueException("Expense must have a value.");
        if (expenseDescription.isBlank())
            throw new InvalidExpenseException("Expense must have a description.");

        this.id = id;
        this.uuid = uuid;
        this.expenseDescription = expenseDescription;
        this.expenseType = expenseType;
        this.value = value;
        this.date = date;
        this.recurrence = recurrence;
        this.beWarned = beWarned;
        this.occurrences = occurrences;
    }
}