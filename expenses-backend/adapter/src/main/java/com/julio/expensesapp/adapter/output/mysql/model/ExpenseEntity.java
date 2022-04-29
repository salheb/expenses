package com.julio.expensesapp.adapter.output.mysql.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "expense")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private UUID UUID;
    @Column
    private String expenseDescription;
    @Column
    private int expenseType;
    @Column
    private BigDecimal value;
    @Column
    private LocalDateTime date;
    @Column
    private int recurrence;
    @Column
    private boolean beWarned;
}