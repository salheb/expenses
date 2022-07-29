package com.julio.expensesapp.output.repository.entity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import javax.inject.Named;
import java.util.Optional;

@Named
@ApplicationScoped
public class UserEntityRepository {
    private final EntityManager entityManager;

    @Inject
    public UserEntityRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(UserEntity entity){
        entityManager.persist(entity);
    }

    public Optional<UserEntity> find(Long id){
        return Optional.ofNullable(entityManager.find(UserEntity.class, id));
    }

    public boolean exists(Long id){
        return entityManager.find(UserEntity.class, id) != null;
    }

    public Optional<UserEntity> findUserByToken(String token) {
        return Optional.ofNullable(entityManager.find(UserEntity.class, token));
    }

    public Optional<UserEntity> findUserByMail(String mail) {
        return Optional.ofNullable(entityManager.find(UserEntity.class, mail));
    }
}
