package com.julio.expensesapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.julio.expensesapp.domain.exception.InvalidExpenseOccurrenceException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class ExpenseOccurrence {

    private long id;
    private UUID uuid;
    private long expenseId;
    private LocalDateTime dateReal;
    private BigDecimal valueReal;

    @Builder
    ExpenseOccurrence(long id,
                      UUID uuid,
                      long expenseId,
                      LocalDateTime dateReal,
                      BigDecimal valueReal){

        if (valueReal.doubleValue() <= 0)
            throw new InvalidExpenseOccurrenceException("An occurrence of an expense must have a value.");
        Objects.requireNonNull(dateReal, "Expense Date can't be null.");
        this.id = id;
        this.uuid = uuid;
        this.expenseId = expenseId;
        this.dateReal = dateReal;
        this.valueReal = valueReal;


    }
}