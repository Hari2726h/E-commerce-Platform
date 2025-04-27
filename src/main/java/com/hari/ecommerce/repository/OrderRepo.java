package com.hari.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.ecommerce.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Long> {
    
}
