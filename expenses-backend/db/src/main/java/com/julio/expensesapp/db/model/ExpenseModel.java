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
    private UUID uuid;
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
    
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
    

    public UUID getUuid(){
        return uuid;
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }


    public String getExpenseDescription(){
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription){
        this.expenseDescription = expenseDescription;
    }


    public int getExpenseType(){
        return expenseType;
    }

    public void setExpenseType(int expenseType){
        this.expenseType = expenseType;
    }



    public BigDecimal getValue(){
        return value;
    }

    public void setValue(BigDecimal value){
        this.value = value;
    }


    
    public LocalDateTime getDate(){
        return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }
    


    public int getRecurrence(){
        return recurrence;
    }

    public void setRecurrence(int recurrence){
        this.recurrence = recurrence;
    }


    public boolean getBeWarned(){
        return beWarned;
    }

    public void setBeWarned(boolean beWarned){
        this.beWarned = beWarned;
    }

}