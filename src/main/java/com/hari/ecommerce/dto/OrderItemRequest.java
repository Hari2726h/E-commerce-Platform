package com.hari.ecommerce.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
 
    private int product_id;
    private int quantity;
}
