package com.hari.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
// import com.hari.ecommerce.entity.Product;
import com.hari.ecommerce.enums.OrderStatus;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDto {
    private Long id;

    private int quantity;
    private BigDecimal price;
    private  OrderStatus status;
    
    private UserDto user;

    private ProductDto product;

    private OrderDto order;

    private LocalDateTime createdAt;


}
