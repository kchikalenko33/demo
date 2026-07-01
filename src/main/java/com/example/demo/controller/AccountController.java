package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody String request) {
        // TODO: реализация создания аккаунта
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void closeAccount(@PathVariable Long id) {
        // TODO: реализация закрытия аккаунта
    }


}
