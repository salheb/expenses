package com.julio.expensesapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ExpenseOccurrence {

    private long id;
    private UUID UUID;
    private long expenseId;
    private LocalDateTime dateReal;
    private BigDecimal valueReal;
}