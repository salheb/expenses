package com.julio.expensesapp.db.mapper;

import java.util.ArrayList;
import java.util.Collection;

import com.julio.expensesapp.db.model.ExpenseModel;
import com.julio.expensesapp.entities.Expense;

public class ExpenseMapper {

    public static Expense toEntity(ExpenseModel model){
        if (model == null){
            return null;
        }

        Expense expense = new Expense();
        expense.setId(model.getId());
        expense.setUuid(model.getUuid());
        expense.setBeWarned(model.getBeWarned());
        expense.setDate(model.getDate());
        expense.setExpenseDescription(model.getExpenseDescription());
        expense.setExpenseType(model.getExpenseType());
        expense.setRecurrence(model.getRecurrence());
        expense.setValue(model.getValue());
        

        return expense;
    }
    
    public static Collection<Expense> toEntity(Collection<ExpenseModel> model){
        if (model == null){
            return null;
        }
        
        Collection<Expense> expenseList = new ArrayList();
        for (ExpenseModel tempExpense : model){
            Expense expense = new Expense();
            expense.setId(tempExpense.getId());
            expense.setUuid(tempExpense.getUuid());
            expense.setBeWarned(tempExpense.getBeWarned());
            expense.setDate(tempExpense.getDate());
            expense.setExpenseDescription(tempExpense.getExpenseDescription());
            expense.setExpenseType(tempExpense.getExpenseType());
            expense.setRecurrence(tempExpense.getRecurrence());
            expense.setValue(tempExpense.getValue());

            expenseList.add(expense);
        }
        
        return expenseList;
    }
    
}