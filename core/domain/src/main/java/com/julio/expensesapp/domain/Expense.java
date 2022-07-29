package com.julio.expensesapp.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
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
    private final ZonedDateTime date;
    private final int recurrence;
    private final boolean beWarned;
    private final List<ExpenseOccurrence> occurrences;
    private final User user;

    @Builder
    Expense(long id,
            UUID uuid,
            String expenseDescription,
            int expenseType,
            BigDecimal value,
            ZonedDateTime date,
            int recurrence,
            boolean beWarned,
            List<ExpenseOccurrence> occurrences,
            User user){


        Objects.requireNonNull(date, "Expense Date can't be null.");
        if (value.doubleValue() <= 0)
            throw new InvalidExpenseValueException("Expense must have a value.");
        if (expenseDescription.isBlank())
            throw new InvalidExpenseException("Expense must have a description.");
        if (user == null) throw new InvalidExpenseException("Expense user can't be identified.");

        this.id = id;
        this.uuid = uuid;
        this.expenseDescription = expenseDescription;
        this.expenseType = expenseType;
        this.value = value;
        this.date = date;
        this.recurrence = recurrence;
        this.beWarned = beWarned;
        this.occurrences = occurrences;
        this.user = user;
    }
}