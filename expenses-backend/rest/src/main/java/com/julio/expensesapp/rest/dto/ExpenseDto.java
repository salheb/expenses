package com.julio.expensesapp.rest.dto;

import lombok.Data;

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