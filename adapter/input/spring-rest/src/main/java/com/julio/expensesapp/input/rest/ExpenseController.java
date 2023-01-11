package com.julio.expensesapp.input.rest;

import com.julio.expensesapp.input.rest.dto.ExpenseDto;
import com.julio.expensesapp.input.rest.mapper.ExpenseControllerMapper;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.usecase.expense.FindExpenseByDateBetweenUseCase;
import com.julio.expensesapp.usecase.expense.FindExpenseByUUIDUseCase;
import com.julio.expensesapp.usecase.expense.SaveExpenseUseCase;
import com.julio.expensesapp.usecase.expense.DeleteExpenseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Api(tags = "Expenses")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private FindExpenseByDateBetweenUseCase findExpenseByDateBetween;

    @Autowired
    private FindExpenseByUUIDUseCase findExpenseByUUIDUseCase;

    @Autowired
    private SaveExpenseUseCase saveExpenseUseCase;

    @Autowired
    private DeleteExpenseUseCase deleteExpenseUseCase;


    @GetMapping(value = {"/"})
    public ResponseEntity<List<ExpenseDto>> find(@RequestParam(required = false) String dateFrom,
                                                 @RequestParam(required = false) String dateTo){

        List<Expense> expenses = findExpenseByDateBetween.find(dateFrom, dateTo);

        return new ResponseEntity<>(ExpenseControllerMapper.toDto(expenses), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<List<ExpenseDto>> find(@PathVariable UUID id){
        Expense expense = findExpenseByUUIDUseCase.find(id);

        ResponseEntity<List<ExpenseDto>> response;
        if (expense == null)
            response = new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        else
        {
            List<ExpenseDto> expenses = new ArrayList<>();
            expenses.add(ExpenseControllerMapper.toDto(expense));

            response = new ResponseEntity<>(expenses, HttpStatus.OK);
        }
        return response;
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExpenseDto add(@RequestBody List<ExpenseDto> expenseDto)
    {
        Expense expense = ExpenseControllerMapper.toEntity(expenseDto.get(0));
        expense = saveExpenseUseCase.save(expense);

        return ExpenseControllerMapper.toDto(expense);
    }

    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExpenseDto update(@RequestBody List<ExpenseDto> expenseDto){
        Expense expense = ExpenseControllerMapper.toEntity(expenseDto.get(0));
        expense = saveExpenseUseCase.save(expense);

        return ExpenseControllerMapper.toDto(expense);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void delete(@RequestBody UUID uuid){
        deleteExpenseUseCase.delete(uuid);
    }

}