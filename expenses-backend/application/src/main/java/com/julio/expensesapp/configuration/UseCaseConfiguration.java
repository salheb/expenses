package com.julio.expensesapp.configuration;

//import com.julio.expensesapp.port.output.mysql.ExpenseAdapterImpl;
import com.julio.expensesapp.usecase.port.ExpenseRepository;
import com.julio.expensesapp.usecase.expense.FindExpenseByDateBetweenUseCase;
import com.julio.expensesapp.usecase.expense.FindExpenseByDateUseCase;
import com.julio.expensesapp.usecase.expense.FindExpenseByUUIDUseCase;
import com.julio.expensesapp.usecase.expense.SaveExpenseUseCase;
import com.julio.expensesapp.usecase.expense.DeleteExpenseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Deprecated
@Configuration
public class UseCaseConfiguration {

    @Bean
    public FindExpenseByDateUseCase findExpenseByDateUseCase(ExpenseRepository expenseRepository){
        return new FindExpenseByDateUseCase(expenseRepository);
    }

    @Bean
    public FindExpenseByDateBetweenUseCase findExpenseByDateBetweenUseCase(ExpenseRepository expenseRepository){
        return new FindExpenseByDateBetweenUseCase(expenseRepository);
    }

    @Bean
    public FindExpenseByUUIDUseCase findExpenseByIdUseCase(ExpenseRepository expenseRepository){
        return new FindExpenseByUUIDUseCase(expenseRepository);
    }

    @Bean
    public ExpenseRepository expenseAdapter(){
        return new ExpenseAdapterImpl();
    }

    @Bean
    public SaveExpenseUseCase saveExpenseUseCase(ExpenseRepository expenseRepository){
        return new SaveExpenseUseCase(expenseRepository);
    }

    @Bean
    public DeleteExpenseUseCase deleteExpenseUseCase(ExpenseRepository expenseRepository){
        return new DeleteExpenseUseCase(expenseRepository);
    }
}*/