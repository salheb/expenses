package com.julio.expensesapp.rest.mapper;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.rest.dto.ExpenseDto;

import java.util.ArrayList;
import java.util.List;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense entity){
        if (entity == null){
            return null;
        }

        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(entity.getId());
        expenseDto.setUuid(entity.getUUID());
        expenseDto.setExpenseType(entity.getExpenseType());
        expenseDto.setExpenseDescription(entity.getExpenseDescription());
        expenseDto.setDate(entity.getDate());
        expenseDto.setBeWarned(entity.isBeWarned());
        expenseDto.setValue(entity.getValue());
        expenseDto.setRecurrence(entity.getRecurrence());

        return expenseDto;
    }

    public static List<ExpenseDto> toDto(List<Expense> entity){
        if (entity == null){
            return null;
        }

        List<ExpenseDto> expenseList = new ArrayList<>();

        for (Expense tempExpense : entity){
            expenseList.add(toDto(tempExpense));
        }

        return expenseList;
    }

}