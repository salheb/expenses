package com.julio.expensesapp.adapter.db.mapper;

import java.util.ArrayList;
import java.util.List;

import com.julio.expensesapp.adapter.db.model.ExpenseModel;
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

    public static ExpenseModel toModel (Expense entity){
        if (entity == null)
            return null;

        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setId(entity.getId());
        expenseModel.setUUID(entity.getUUID());
        expenseModel.setExpenseType(entity.getExpenseType());
        expenseModel.setExpenseDescription(entity.getExpenseDescription());
        expenseModel.setBeWarned(entity.isBeWarned());
        expenseModel.setDate(entity.getDate());
        expenseModel.setRecurrence(entity.getRecurrence());
        expenseModel.setValue(entity.getValue());

        return expenseModel;
    }
    
}