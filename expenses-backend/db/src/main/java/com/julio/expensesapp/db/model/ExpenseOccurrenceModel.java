package com.julio.expensesapp.db.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "expense_occurrence")
@Entity
@Data
public class ExpenseOccurrenceModel {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private UUID UUID;
    @Column
    private long expenseId;
    @Column
    private LocalDateTime dateReal;
    @Column
    private BigDecimal valueReal;

}
