package com.julio.expensesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.julio.expensesapp")
@EnableJpaRepositories(basePackages = "com.julio.expensesapp.adapter.db")
@EntityScan(basePackages = "com.julio.expensesapp.entities")
public class Application {

    public static void main(String[] args) throws Exception {
        // TODO add security / authentication to API
        //System.out.println("Expenses Backend App - version 0.0.1");

        SpringApplication.run(Application.class, args);
    }
}