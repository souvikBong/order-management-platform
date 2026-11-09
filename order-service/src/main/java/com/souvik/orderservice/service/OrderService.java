package com.souvik.orderservice.service;


import com.souvik.orderservice.dto.CreateOrderRequest;
import com.souvik.orderservice.dto.OrderResponse;
import com.souvik.orderservice.entity.Order;
import com.souvik.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public OrderResponse createOrder(CreateOrderRequest request) {

        Order order = Order.builder()
                .customerName(request.getCustomerName())
                .productName(request.getProductName())
                .quantity(request.getQuantity())
                .status("CREATED")
                .build();

        Order savedOrder = repository.save(order);

        return OrderResponse.builder()
                .id(savedOrder.getId())
                .customerName(savedOrder.getCustomerName())
                .productName(savedOrder.getProductName())
                .quantity(savedOrder.getQuantity())
                .status(savedOrder.getStatus())
                .build();
    }
}
