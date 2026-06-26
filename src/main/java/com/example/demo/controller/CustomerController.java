package com.example.demo.controller;

import com.example.demo.model.CustomerDto;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(@Qualifier("Customer") CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto) {
        log.info("Получен POST запрос на создание Customer " + customerDto.getName());
        return new ResponseEntity<>(customerService.create(customerDto),
                HttpStatus.CREATED);
    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerDto>> readAll() {
        log.info("Получен GET запрос на получение всех Customer");
        return new ResponseEntity<>(customerService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> readById(@PathVariable Integer customerId) {
        log.info("Получен GET запрос на получение Customer по Id = 's'".formatted(customerId));
        return new ResponseEntity<>(customerService.readById(customerId), HttpStatus.OK);
    }

    @PutMapping("update/{customerDto}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        log.info("Получен PUT запрос на обновление Customer " + customerDto.getName());
        return new ResponseEntity<>(customerService.updateCustomer(customerDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{customerId}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Integer customerId) {
        log.info("Получен DELETE запрос на удаление Customer по Id = 's'".formatted(customerId));
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }

}
