package com.julio.expensesapp.adapter.output.mysql;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.julio.expensesapp.adapter.output.mysql.mapper.ExpenseMapper;
import com.julio.expensesapp.adapter.output.mysql.model.ExpenseEntity;
import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecases.adapter.ExpenseAdapter;

public class ExpenseAdapterImpl implements ExpenseAdapter {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll(){
        List<ExpenseEntity> findAll = expenseRepository.findAll();

        return ExpenseMapper.toEntity(findAll);
    }

    @Override
    public List<Expense> findExpenseByDate(ZonedDateTime date){
        List<ExpenseEntity> findByDate = expenseRepository.findByDate(date);

        return ExpenseMapper.toEntity(findByDate);
    }

    @Override
    public List<Expense> findExpenseByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo){
        List<ExpenseEntity> findByDate = expenseRepository.findByDateBetween(dateFrom, dateTo);
        return ExpenseMapper.toEntity(findByDate);
    }

    @Override
    public Expense findExpenseByUUID(UUID uuid){
        ExpenseEntity findByUUID = expenseRepository.findByUUID(uuid);

        return ExpenseMapper.toEntity(findByUUID);
    }

    @Override
    public Expense findExpenseById(long id) {
        ExpenseEntity findById = expenseRepository.findById(id);

        return ExpenseMapper.toEntity(findById);
    }

    @Override
    public Expense save(Expense expense){
        ExpenseEntity expenseEntity = ExpenseMapper.toModel(expense);

        expenseEntity = expenseRepository.save(expenseEntity);

        return ExpenseMapper.toEntity(expenseEntity);
    }

    @Override
    public void delete(UUID uuid){
        ExpenseEntity deleteModel = expenseRepository.findByUUID(uuid);
        expenseRepository.delete(deleteModel);
    }
    
}