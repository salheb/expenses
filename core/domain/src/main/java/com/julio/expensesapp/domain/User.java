package com.julio.expensesapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.Objects;

@Builder
@ToString
@Getter
public class User {
    private final long id;
    private final String mail;
    private final AuthMethod authMethod;
    private final String token;
    private final ZonedDateTime tokenUpdatedAt;

    @Builder
    User(long id,
         String mail,
         AuthMethod authMethod,
         String token,
         ZonedDateTime tokenUpdatedAt){
        Objects.requireNonNull(mail, "Mail can't be empty.");
        Objects.requireNonNull(authMethod, "Authentication method can't be empty.");
        this.id = id;
        this.mail = mail;
        this.authMethod = authMethod;
        this.token = token;
        this.tokenUpdatedAt = tokenUpdatedAt;
    }
}
