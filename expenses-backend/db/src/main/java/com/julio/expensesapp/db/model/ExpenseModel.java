package com.julio.expensesapp.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
 
@Table(name = "expense")
@Entity
@Data
public class ExpenseModel implements Serializable {

    private static final long serialVersionUID = 1L;

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