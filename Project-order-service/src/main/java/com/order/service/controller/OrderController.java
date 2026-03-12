package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.entity.Order;
import com.order.service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderService orderservice;
	
	@PostMapping
    public ResponseEntity<Order> createProduct(@RequestBody Order order) {
        Order saved = orderservice.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
