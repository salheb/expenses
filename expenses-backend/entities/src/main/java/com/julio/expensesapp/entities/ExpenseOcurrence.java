package com.julio.expensesapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExpenseOcurrence {

    private long id;
    private UUID uid;
    private long expenseId;
    private LocalDateTime dateReal;
    private BigDecimal valueReal;

    public long getId() {
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public UUID getUuid() {
        return uid;
    }
    public void setUuid(UUID uid){
        this.uid = uid;
    }

    public long getExpenseId() {
        return expenseId;
    }
    public void setExpenseId(long expenseId){
        this.expenseId = expenseId;
    }

    public BigDecimal getValueReal() {
        return valueReal;
    }
    public void setValueReal(BigDecimal valueReal){
        this.valueReal = valueReal;
    }

    public LocalDateTime getDateReal() {
        return dateReal;
    }
    public void setDateReal(LocalDateTime dateReal){
        this.dateReal = dateReal;
    }
    
}