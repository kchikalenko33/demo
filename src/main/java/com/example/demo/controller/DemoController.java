package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/ok")
    public ResponseEntity<String> okExample() {
        return ResponseEntity.ok("Успешный ответ");
    }

    @PostMapping("/created")
    public ResponseEntity<String> createdExample() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ресурс создан");
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFoundExample() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ресурс не найден");
    }

    @GetMapping("/bad-request")
    public ResponseEntity<String> badRequestExample() {
        return ResponseEntity
                .badRequest()
                .body("Некорректный запрос");
    }
}
