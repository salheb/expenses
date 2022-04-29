package com.julio.expensesapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class ExpenseOccurrence {

    private long id;
    private UUID uuid;
    private long expenseId;
    private LocalDateTime dateReal;
    private BigDecimal valueReal;
}