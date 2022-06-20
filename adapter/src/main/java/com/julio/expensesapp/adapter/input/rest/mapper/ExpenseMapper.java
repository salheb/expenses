package com.julio.expensesapp.adapter.input.rest.mapper;

import com.julio.expensesapp.adapter.input.rest.dto.ExpenseDto;
import com.julio.expensesapp.domain.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense entity){
        if (entity == null){
            return null;
        }

        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(entity.getId());
        expenseDto.setUuid(entity.getUuid());
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

        Expense expense = Expense.builder()
                .id(dto.getId())
                .expenseDescription(dto.getExpenseDescription())
                .expenseType(dto.getExpenseType())
                .beWarned(dto.isBeWarned())
                .date(dto.getDate())
                .recurrence(dto.getRecurrence())
                .uuid(dto.getUuid())
                .value(dto.getValue())
                .build();


        return expense;
    }
}