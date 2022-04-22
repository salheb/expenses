package com.julio.expensesapp.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/security")
public class AuthenticationController {

    @GetMapping
    public ResponseEntity<Void> security(){
        return ResponseEntity.ok().build();
    }
}
