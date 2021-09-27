package com.julio.expensesapp.rest;


import com.julio.expensesapp.entities.Expense;
import com.julio.expensesapp.rest.dto.ExpenseDto;
import com.julio.expensesapp.usecases.expense.FindExpenseByDateBetweenUseCase;
import com.julio.expensesapp.rest.mapper.ExpenseMapper;

import com.julio.expensesapp.usecases.expense.FindExpenseByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class ExpenseController {

    @Autowired
    private FindExpenseByDateBetweenUseCase findExpenseByDateBetween;

    @Autowired
    private FindExpenseByIdUseCase findExpenseByIdUseCase;

    @GetMapping(value = {"/expenses/{dateFrom}/{dateTo}/{id}", "/expenses/{dateFrom}/{dateTo}", "/expenses"})
    public ResponseEntity<List<ExpenseDto>> findByDate(@PathVariable(required = false) String dateFrom,
                                                       @PathVariable(required = false) String dateTo,
                                                       @PathVariable(required = false) Integer id){

        if (dateFrom != null && id == null) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDateTime dateTimeFrom;
            LocalDateTime dateTimeTo;

            System.out.println("Valores passados como parametros : dateFrom = " + dateFrom + " / dateTo = "+ dateTo);

            try {
                dateTimeFrom = LocalDate.parse(dateFrom, formatter).atStartOfDay();
                if (dateTo != null)
                    dateTimeTo = LocalDate.parse(dateTo, formatter).atTime(LocalTime.MAX);
                else
                    dateTimeTo = LocalDate.parse(dateFrom, formatter).atTime(LocalTime.MAX);
            } catch (DateTimeParseException e) {
                dateTimeFrom = LocalDate.now().atStartOfDay();
                dateTimeTo = LocalDate.now().atTime(LocalTime.MAX);
                System.out.println("Failed to convert date parameters. Using today as the queried date. Exception details : " + e);
            }

            List<Expense> expenses = findExpenseByDateBetween.find(dateTimeFrom, dateTimeTo);

            ResponseEntity<List<ExpenseDto>> response = new ResponseEntity<>(ExpenseMapper.toDto(expenses), HttpStatus.OK);
            return response;
        }
        else if (id != 0){
            System.out.println(id);

            Expense expense = findExpenseByIdUseCase.find(id);

            List<ExpenseDto> expenses = new ArrayList<>();
            expenses.add(ExpenseMapper.toDto(expense));
            ResponseEntity<List<ExpenseDto>> response = new ResponseEntity<>(expenses, HttpStatus.OK);
            return response;
        }
        else
        {
            ResponseEntity<List<ExpenseDto>> response = new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
            return response;
        }


    }

    @PostMapping(path = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpenseDto> create(@RequestBody Expense newExpense){

        return new ResponseEntity<>(ExpenseMapper.toDto(new Expense()), HttpStatus.OK);
    }
}
