package com.souvik.orderservice.controller;

import com.souvik.orderservice.dto.CreateOrderRequest;
import com.souvik.orderservice.dto.OrderResponse;
import com.souvik.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public OrderResponse createOrder(
            @RequestBody CreateOrderRequest request) {

        return service.createOrder(request);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(
            @PathVariable Long id) {

        return service.getOrderById(id);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {

        return service.getAllOrders();
    }
}