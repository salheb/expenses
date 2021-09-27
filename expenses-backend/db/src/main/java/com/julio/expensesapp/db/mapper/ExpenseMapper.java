package com.julio.expensesapp.db.mapper;

import java.util.ArrayList;
import java.util.List;

import com.julio.expensesapp.db.model.ExpenseModel;
import com.julio.expensesapp.entities.Expense;

public class ExpenseMapper {

    public static Expense toEntity(ExpenseModel model){
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
    
    public static List<Expense> toEntity(List<ExpenseModel> model){
        if (model == null){
            return null;
        }

        List<Expense> expenseList = new ArrayList();
        for (ExpenseModel tempExpense : model){
            expenseList.add(toEntity(tempExpense));
        }
        
        return expenseList;
    }
    
}