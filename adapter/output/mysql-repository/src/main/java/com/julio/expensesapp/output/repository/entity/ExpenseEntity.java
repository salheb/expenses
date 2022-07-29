package com.julio.expensesapp.output.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Table(name = "expense", schema = "musa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExpenseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column
    @GeneratedValue
    private java.util.UUID UUID;
    @Column
    private String expenseDescription;
    @Column
    private int expenseType;
    @Column
    private BigDecimal value;
    @Column
    private ZonedDateTime date;
    @Column
    private int recurrence;
    @Column
    private boolean beWarned;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expense")
    private List<ExpenseOccurrenceEntity> occurrences;
}
