package com.julio.expensesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {

        System.out.println("Expenses App - version 0.0.1");
        SpringApplication.run(Application.class, args);
    }
}