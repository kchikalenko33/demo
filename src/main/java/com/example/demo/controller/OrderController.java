package com.example.demo.controller;

import com.example.demo.model.OrderDto;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto,
                                                @RequestParam("customerId") Integer customerId) {
        log.info("Получен POST запрос на создание Order " + orderDto.getName());
        return new ResponseEntity<>(orderService.createOrder(orderDto, customerId), HttpStatus.CREATED);
    }

    @GetMapping("orders")
    public ResponseEntity<List<OrderDto>> readAll() {
        log.info("Получен GET запрос на получение всех Order");
        return new ResponseEntity<>(orderService.readAll(), HttpStatus.OK);
    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<OrderDto> readById(@PathVariable Integer orderId) {
        log.info("Получен GET запрос на получение Order по Id = 's'".formatted(orderId));
        return new ResponseEntity<>(orderService.readById(orderId), HttpStatus.OK);
    }

    @PutMapping("/orderUpdate")
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto orderDto) {
        log.info("Получен PUT запрос на обновление Order " + orderDto.getName());
        return new ResponseEntity<>(orderService.updateOrder(orderDto), HttpStatus.OK);
    }

    @DeleteMapping("deleteOrder")
    public ResponseEntity<OrderDto> delete(@RequestBody OrderDto orderDto) {
        log.info("Получен DELETE запрос на удаление Order");
        return new ResponseEntity<>(orderService.delete(orderDto), HttpStatus.OK);
    }

    @GetMapping("ordersByCustomer/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrderByCustomerAndDate(@PathVariable Integer customerId,
                                                         @RequestParam("day") Integer day,
                                                         @RequestParam("month") Integer month,
                                                         @RequestParam("year") Integer year) {
        log.info("Получен GET запрос на получение всех Orders у Customer за дату");
        return new ResponseEntity<>(orderService.getOrderByCustomerAndDate(customerId, day, month, year), HttpStatus.OK);
    }

}
