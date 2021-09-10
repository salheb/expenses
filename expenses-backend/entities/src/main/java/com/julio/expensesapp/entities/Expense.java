package com.julio.expensesapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Expense {
    
    private long id;
    private UUID uuid;
	private String expenseDescription;
	private int expenseType;
    private BigDecimal value;
    private LocalDateTime date;
    private int recurrence;
    private boolean beWarned;

    public long getId() {
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uid){
        this.uuid = uid;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }
    public void setExpenseDescription(String expenseDescription){
        this.expenseDescription = expenseDescription;
    }

    public int getExpenseType() {
        return expenseType;
    }
    public void setExpenseType(int expenseType){
        this.expenseType = expenseType;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value){
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public int getRecurrence() {
        return recurrence;
    }
    public void setRecurrence(int recurrence){
        this.recurrence = recurrence;
    }

    public boolean getBeWarned() {
        return beWarned;
    }
    public void setBeWarned(boolean beWarned){
        this.beWarned = beWarned;
    }
        
    
}