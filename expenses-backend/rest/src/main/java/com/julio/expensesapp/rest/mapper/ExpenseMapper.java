package com.julio.expenseapp.rest.mapper;

import com.julio.expenseapp.entities.Expense;
import com.julio.expenseapp.rest.dto.ExpenseDto;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense entity){
        if (entity == null){
            return null;
        }

        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(entity.getId());
        expenseDto.getUuid(entity.setUuid());
        
    }
}