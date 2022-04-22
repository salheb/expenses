package com.julio.expensesapp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Profile("secure-api-jwk")
@Configuration
public class JwtDecoderConfig {

    @Bean
    public JwtDecoder jwtDecoder(
            @Value("${security.jwt.signature.jwk-set-uri}") String jwkSetUri) {

        System.out.println("Using JWK to decode token");
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}
