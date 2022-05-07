package com.julio.expensesapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
        this.id = id;
        this.uuid = uuid;
        this.expenseId = expenseId;
        this.dateReal = dateReal;
        this.valueReal = valueReal;
    }
}