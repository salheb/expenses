package com.julio.expensesapp.adapter.output.mysql.mapper;

import java.util.ArrayList;
import java.util.List;

import com.julio.expensesapp.adapter.output.mysql.model.ExpenseEntity;
import com.julio.expensesapp.domain.Expense;

public class ExpenseMapper {

    public static Expense toEntity(ExpenseEntity model){
        if (model == null){
            return null;
        }

        Expense expense = new Expense();

        expense.setId(model.getId());
        expense.setUUID(model.getUUID());
        expense.setBeWarned(model.isBeWarned());
        expense.setDate(model.getDate());
        expense.setExpenseDescription(model.getExpenseDescription());
        expense.setExpenseType(model.getExpenseType());
        expense.setRecurrence(model.getRecurrence());
        expense.setValue(model.getValue());
        

        return expense;
    }
    
    public static List<Expense> toEntity(List<ExpenseEntity> model){
        if (model == null){
            return null;
        }

        List<Expense> expenseList = new ArrayList();
        for (ExpenseEntity tempExpense : model){
            expenseList.add(toEntity(tempExpense));
        }
        
        return expenseList;
    }

    public static ExpenseEntity toModel (Expense entity){
        if (entity == null)
            return null;

        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setId(entity.getId());
        expenseEntity.setUUID(entity.getUUID());
        expenseEntity.setExpenseType(entity.getExpenseType());
        expenseEntity.setExpenseDescription(entity.getExpenseDescription());
        expenseEntity.setBeWarned(entity.isBeWarned());
        expenseEntity.setDate(entity.getDate());
        expenseEntity.setRecurrence(entity.getRecurrence());
        expenseEntity.setValue(entity.getValue());

        return expenseEntity;
    }
    
}