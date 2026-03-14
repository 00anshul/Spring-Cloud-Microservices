package com.order.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.service.client.ProductClient;
import com.order.service.dto.ProductDTO;
import com.order.service.entity.Order;
import com.order.service.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductClient productClient;

    @CircuitBreaker(name="product-service",fallbackMethod="createOrderFallback")
    public Order createOrder(Order order) {
        // Step 1 — Fetch product details from Product Service
        ProductDTO product = productClient.getProductById(order.getProduct_id());

        // Step 2 — Set fields pulled from Product Service
        order.setProduct_price(product.getProduct_price());
        order.setPro_desc(product.getPro_desc());

        // Step 3 — Save and return
        return orderRepo.save(order);
    }
    public Order createOrderFallback(Order order, Throwable ex) {
        Order fallbackOrder = new Order();
//        fallbackOrder.setProduct_id(order.getProduct_id());
//        fallbackOrder.setProduct_quantity(order.getProduct_quantity());
//        fallbackOrder.setProduct_price(0);
        fallbackOrder.setPro_desc("Product Service is currently unavailable. Please try again later.");
        return fallbackOrder;
    }
}