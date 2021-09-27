package com.julio.expensesapp.db.mapper;

import com.julio.expensesapp.db.model.ExpenseOccurrenceModel;
import com.julio.expensesapp.entities.ExpenseOccurrence;

import java.util.ArrayList;
import java.util.List;

public class ExpenseOccurrenceMapper {
    public static ExpenseOccurrence toEntity(ExpenseOccurrenceModel model){
        if (model == null){
            return null;
        }

        ExpenseOccurrence occurrence = new ExpenseOccurrence();

        occurrence.setId(model.getId());
        occurrence.setExpenseId(model.getExpenseId());
        occurrence.setDateReal(model.getDateReal());
        occurrence.setUUID(model.getUUID());
        occurrence.setValueReal(model.getValueReal());

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
