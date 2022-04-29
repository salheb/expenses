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
public class Expense {
    
    private final long id;
    private final UUID uuid;
	private final String expenseDescription;
	private final int expenseType;
    private final BigDecimal value;
    private final LocalDateTime date;
    private final int recurrence;
    private final boolean beWarned;
}