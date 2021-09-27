package com.julio.expensesapp.usecases.expense;

import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

import java.time.LocalDateTime;
import java.util.List;

public class FindExpenseByDateBetweenUseCase {

    private ExpenseAdapter adapter;

    public FindExpenseByDateBetweenUseCase(ExpenseAdapter adapter){
        this.adapter = adapter;
    }

    public List<Expense> find(LocalDateTime dateFrom, LocalDateTime dateTo){
        List<Expense> response = adapter.findExpenseByDateBetween(dateFrom, dateTo);
        System.out.println("Conteúdo da lista no usecase: " + response);
        return response;
    }
}
