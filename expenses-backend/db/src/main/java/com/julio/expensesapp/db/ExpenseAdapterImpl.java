package com.julio.expensesapp.db;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.julio.expensesapp.db.mapper.ExpenseMapper;
import com.julio.expensesapp.db.model.ExpenseModel;
import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class ExpenseAdapterImpl implements ExpenseAdapter {


    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll(){
        List<ExpenseModel> findAll = expenseRepository.findAll();

        return ExpenseMapper.toEntity(findAll);
    }

    @Override
    public List<Expense> findExpenseByDate(LocalDateTime date){
        List<ExpenseModel> findByDate = expenseRepository.findByDate(date);

        return ExpenseMapper.toEntity(findByDate);
    }

    @Override
    public List<Expense> findExpenseByDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo){
        List<ExpenseModel> findByDate = expenseRepository.findByDateBetween(dateFrom, dateTo);
        System.out.println("----------- ExpenseAdapterImpl.java -------------");
        System.out.println("Response list inside adapter implementation: " + findByDate);
        System.out.println("dateFrom: " + dateFrom + " / dateTo: " + dateTo);
        System.out.println("----------- ExpenseAdapterImpl.java -------------");
        return ExpenseMapper.toEntity(findByDate);
    }

    @Override
    public Expense findExpenseByUUID(UUID uuid){
        ExpenseModel findByUUID = expenseRepository.findByUUID(uuid);

        return ExpenseMapper.toEntity(findByUUID);
    }

    @Override
    public Expense findExpenseById(long id) {
        ExpenseModel findById = expenseRepository.findById(id);

        return ExpenseMapper.toEntity(findById);
    }
    
}