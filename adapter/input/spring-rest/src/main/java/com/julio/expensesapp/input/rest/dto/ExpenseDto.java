package com.julio.expensesapp.input.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ExpenseDto {
    private long id;
    private UUID uuid;
    private String expenseDescription;
    private int expenseType;
    private BigDecimal value;
    private ZonedDateTime date;
    private int recurrence;
    private boolean beWarned;
}