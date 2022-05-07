package com.julio.expensesapp.adapter.output.mysql.mapper;

import com.julio.expensesapp.adapter.output.mysql.model.ExpenseOccurrenceModel;
import com.julio.expensesapp.domain.ExpenseOccurrence;

import java.util.ArrayList;
import java.util.List;

public class ExpenseOccurrenceMapper {
    public static ExpenseOccurrence toEntity(ExpenseOccurrenceModel model){
        if (model == null){
            return null;
        }

        ExpenseOccurrence occurrence = ExpenseOccurrence.builder()
                                        .id(model.getId())
                                        .uuid(model.getUUID())
                                        .expenseId(model.getExpenseId())
                                        .dateReal(model.getDateReal())
                                        .valueReal(model.getValueReal())
                                        .build();

        return occurrence;
    }

    public static List<ExpenseOccurrence> toEntity(List<ExpenseOccurrenceModel> model){
        if (model == null){
            return null;
        }

        List<ExpenseOccurrence> occurrenceList = new ArrayList<>();

        for (ExpenseOccurrenceModel tempOccurrence : model){
            occurrenceList.add(toEntity(tempOccurrence));
        }

        return occurrenceList;
    }

}
