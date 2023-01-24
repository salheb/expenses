package com.julio.expensesapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile("secure-api-jwk")
@Configuration
public class ResourceServerConfiguration  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeRequests()
                /*.requestMatchers("/auth")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs")
                .permitAll()
                .requestMatchers("/swagger-ui/**")
                .permitAll()
                .requestMatchers( "/swagger-resources/**")
                .permitAll()
                .and()
                .authorizeRequests()*/
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                //.and()
                //.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter())
        ;

        return httpSecurity.build();
    }
}
