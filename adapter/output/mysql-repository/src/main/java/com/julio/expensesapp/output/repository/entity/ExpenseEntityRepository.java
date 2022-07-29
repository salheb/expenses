package com.julio.expensesapp.output.repository.entity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Named
@ApplicationScoped
public class ExpenseEntityRepository {
    private final EntityManager entityManager;

    @Inject
    public ExpenseEntityRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(ExpenseEntity entity){
        entityManager.persist(entity);
    }

    public List<ExpenseEntity> findAll(long userId){
        String jpql = "select e from expense e where e.userId = :userId";
        return entityManager.createQuery(jpql, ExpenseEntity.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<ExpenseEntity> findByDate(ZonedDateTime date){
        String jpql = "select e from expense e where e.date BETWEEN :startDate AND :endDate";
        return entityManager.createQuery(jpql, ExpenseEntity.class)
                .setParameter("startDate", date.toLocalDate().atStartOfDay(ZoneId.systemDefault()))
                .setParameter("endDate", date.toLocalDate().atTime(LocalTime.MAX))
                .getResultList();
    }

    public List<ExpenseEntity> findByDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo)
    {
        String jpql = "select e from expense e where e.date BETWEEN :startDate AND :endDate";
        return entityManager.createQuery(jpql, ExpenseEntity.class)
                .setParameter("startDate", dateFrom.toLocalDate().atStartOfDay(ZoneId.systemDefault()))
                .setParameter("endDate", dateTo.toLocalDate().atStartOfDay(ZoneId.systemDefault()))
                .getResultList();
    }

    public Optional<ExpenseEntity> findByUUID(UUID uuid){
        ExpenseEntity expense = entityManager.find(ExpenseEntity.class, uuid);
        return Optional.ofNullable(expense);
    }

    public Optional<ExpenseEntity> findById(long id){
        ExpenseEntity expense = entityManager.find(ExpenseEntity.class, id);
        return Optional.ofNullable(expense);
    }

    public void delete(UUID uuid){
        ExpenseEntity entity = entityManager.find(ExpenseEntity.class, uuid);
        entityManager.remove(entity);
    }

    public boolean exists(UUID uuid){
        ExpenseEntity expense = entityManager.find(ExpenseEntity.class, uuid);
        return Optional.ofNullable(expense).isPresent();
    }


}
