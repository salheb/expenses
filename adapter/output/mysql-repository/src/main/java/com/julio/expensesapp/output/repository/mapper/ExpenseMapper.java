package com.julio.expensesapp.output.repository.mapper;

import com.julio.expensesapp.domain.Expense;
import com.julio.expensesapp.domain.ExpenseOccurrence;
import com.julio.expensesapp.domain.User;
import com.julio.expensesapp.output.repository.entity.AuthMethodEntity;
import com.julio.expensesapp.output.repository.entity.ExpenseEntity;
import com.julio.expensesapp.output.repository.entity.ExpenseOccurrenceEntity;
import com.julio.expensesapp.output.repository.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ExpenseMapper {

    public ExpenseEntity toEntity(final Expense expense){
        return ExpenseEntity.builder()
                .id(expense.getId())
                .UUID(expense.getUuid())
                .beWarned(expense.isBeWarned())
                .date(expense.getDate())
                .expenseDescription(expense.getExpenseDescription())
                .expenseType(expense.getExpenseType())
                .recurrence(expense.getRecurrence())
                .value(expense.getValue())
                .user(toUserEntity(expense.getUser()))
                .build();
    }

    public Expense toDomain(final ExpenseEntity entity){
        return Expense.builder()
                .id(entity.getId())
                .beWarned(entity.isBeWarned())
                .date(entity.getDate())
                .expenseDescription(entity.getExpenseDescription())
                .expenseType(entity.getExpenseType())
                .occurrences(toExpenseOccurrenceDomain(entity.getOccurrences()))
                .build();
    }

    public List<Expense> toDomain(final List<ExpenseEntity> entity){
        List<Expense> expenseList = Collections.emptyList();
        for (ExpenseEntity e: entity){
            expenseList.add(toDomain(e));
        }
        return expenseList;
    }

    private List<ExpenseOccurrence> toExpenseOccurrenceDomain(final List<ExpenseOccurrenceEntity> occurrences){
        return occurrences != null ? occurrences.stream()
                .map(o -> ExpenseOccurrence.builder()
                        .id(o.getId())
                        .dateReal(o.getDateReal())
                        .uuid(o.getUuid())
                        .valueReal(o.getValueReal())
                        .build())
                .collect(Collectors.toList()):Collections.emptyList();

    }

    private UserEntity toUserEntity(final User user){
        return user != null ? UserEntity.builder()
                .id(user.getId())
                .authMethodEntity(AuthMethodEntity.valueOf(user.getAuthMethod().toString()))
                .mail(user.getMail())
                .token(user.getToken())
                .tokenUpdatedAt(user.getTokenUpdatedAt())
                .build()
                : UserEntity.builder().build();
    }
}
