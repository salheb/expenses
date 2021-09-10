package com.julio.expensesapp.db;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import com.julio.expensesapp.db.mapper.ExpenseMapper;
import com.julio.expensesapp.db.model.ExpenseModel;
import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class ExpenseAdapterImpl implements ExpenseAdapter {


    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Collection<Expense> getAllExpenses(){
        Collection<ExpenseModel> getAllExpenses = expenseRepository.getAllExpenses();

        return ExpenseMapper.toEntity(getAllExpenses);
    }

    @Override
    public Collection<Expense> findExpenseByDate(LocalDateTime date){
        Collection<ExpenseModel> findByDate = expenseRepository.findByDate(date);

        return ExpenseMapper.toEntity(findByDate);
    }

    @Override
    public Expense findExpenseByUUID(UUID uuid){
        ExpenseModel findByUUID = expenseRepository.findByUUID(uuid);

        return ExpenseMapper.toEntity(findByUUID);
    }

    @Override
    public Expense findExpenseById(long id) {
        ExpenseModel findById = expenseRepository.findByid(id);

        return ExpenseMapper.toEntity(findById);
    }
    
}