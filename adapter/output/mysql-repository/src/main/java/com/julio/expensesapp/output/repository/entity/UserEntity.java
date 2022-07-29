package com.julio.expensesapp.output.repository.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Table(name = "user", schema = "musa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_mail")
    private String mail;
    @Column(name = "auth_method")
    @Enumerated(EnumType.STRING)
    private AuthMethodEntity authMethodEntity;
    @Column(name = "auth_token")
    private String token;
    @Column(name = "auth_token_updated_at")
    private ZonedDateTime tokenUpdatedAt;
}
