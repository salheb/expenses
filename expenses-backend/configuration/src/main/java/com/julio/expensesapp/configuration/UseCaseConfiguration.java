package com.julio.expensesapp.configuration;

import com.julio.expensesapp.adapter.db.ExpenseAdapterImpl;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;
import com.julio.expensesapp.usecases.expense.FindExpenseByDateBetweenUseCase;
import com.julio.expensesapp.usecases.expense.FindExpenseByDateUseCase;
import com.julio.expensesapp.usecases.expense.FindExpenseByIdUseCase;
import com.julio.expensesapp.usecases.expense.SaveExpenseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public FindExpenseByDateUseCase findExpenseByDateUseCase(ExpenseAdapter expenseAdapter){
        return new FindExpenseByDateUseCase(expenseAdapter);
    }

    @Bean
    public FindExpenseByDateBetweenUseCase findExpenseByDateBetweenUseCase(ExpenseAdapter expenseAdapter){
        return new FindExpenseByDateBetweenUseCase(expenseAdapter);
    }

    @Bean
    public FindExpenseByIdUseCase findExpenseByIdUseCase(ExpenseAdapter expenseAdapter){
        return new FindExpenseByIdUseCase(expenseAdapter);
    }

    @Bean
    public ExpenseAdapter expenseAdapter(){
        return new ExpenseAdapterImpl();
    }

    @Bean
    public SaveExpenseUseCase saveExpenseUseCase(ExpenseAdapter expenseAdapter){
        return new SaveExpenseUseCase(expenseAdapter);
    }
}
