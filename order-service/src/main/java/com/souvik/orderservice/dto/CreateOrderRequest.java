package com.souvik.orderservice.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private String customerName;
    private String productName;
    private Integer quantity;
}