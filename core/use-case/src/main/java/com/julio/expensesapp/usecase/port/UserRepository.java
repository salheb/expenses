package com.julio.expensesapp.usecase.port;

import com.julio.expensesapp.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> find(long id);
    Optional<User> findUserByToken(String token);
    Optional<User> findUserByMail(String mail);
    boolean exists(long id);
    User save(User user);
}
