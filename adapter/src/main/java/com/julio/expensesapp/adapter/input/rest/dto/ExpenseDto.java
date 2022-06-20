package com.julio.expensesapp.adapter.input.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ExpenseDto {
    private long id;
    private UUID uuid;
	private String expenseDescription;
	private int expenseType;
    private BigDecimal value;
    private LocalDateTime date;
    private int recurrence;
    private boolean beWarned;
}