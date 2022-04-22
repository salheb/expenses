package com.julio.expensesapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Expense {
    
    private long id;
    private UUID UUID;
	private String expenseDescription;
	private int expenseType;
    private BigDecimal value;
    private LocalDateTime date;
    private int recurrence;
    private boolean beWarned;
}