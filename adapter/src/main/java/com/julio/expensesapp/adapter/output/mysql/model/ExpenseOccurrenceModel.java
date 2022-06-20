package com.julio.expensesapp.adapter.output.mysql.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "expense_occurrence")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
