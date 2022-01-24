package com.julio.expensesapp.adapter.rest.mapper;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.adapter.rest.dto.ExpenseDto;

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
    public static Expense toEntity(ExpenseDto dto){
        if (dto == null)
            return null;

        Expense expense = new Expense();
        expense.setExpenseType(dto.getExpenseType());
        expense.setExpenseDescription(dto.getExpenseDescription());
        expense.setDate(dto.getDate());
        expense.setBeWarned(dto.isBeWarned());
        expense.setRecurrence(dto.getRecurrence());
        expense.setUUID(dto.getUuid());
        expense.setValue(dto.getValue());
        expense.setId(dto.getId());

        return expense;
    }
}