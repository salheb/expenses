package com.julio.expensesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.julio.expensesapp")
public class Application {

    public static void main(String[] args) throws Exception {
        // TODO add security / authentication to API
        //System.out.println("Expenses Backend App - version 0.0.1");

        SpringApplication.run(Application.class, args);
    }
}