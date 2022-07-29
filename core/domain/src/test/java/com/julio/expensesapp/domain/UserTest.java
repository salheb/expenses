package com.julio.expensesapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    void shouldReturnValuesWhenUserWasCreated(){
        var user = User.builder()
                .id(1)
                .mail("julio.salheb@gmail.com")
                .authMethod(AuthMethod.GOOGLE)
                .token("test")
                .build();
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getMail()).isEqualTo("julio.salheb@gmail.com");
        assertThat(user.getToken()).isEqualTo("test");
        assertThat(user.getAuthMethod()).isEqualTo(AuthMethod.GOOGLE);

    }

    @Test
    void shouldThrowInvalidUserDataException(){
        var userBuilder = User.builder()
                .id(1)
                .mail("julio.salheb@gmail.com")
                .token("test");
        assertThatThrownBy(() -> userBuilder.build()).hasMessage("Authentication method can't be empty.");

        var secondUserBuilder = User.builder()
                .id(1)
                .authMethod(AuthMethod.GOOGLE)
                .token("test");
        assertThatThrownBy(() -> secondUserBuilder.build()).hasMessage("Mail can't be empty.");
    }
}
