package com.julio.expensesapp.output.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Table(name = "expense_occurrence", schema = "musa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExpenseOccurrenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @GeneratedValue(generator = "UUID")
    private java.util.UUID uuid;

    @Column
    private ZonedDateTime dateReal;
    @Column
    private BigDecimal valueReal;


}
