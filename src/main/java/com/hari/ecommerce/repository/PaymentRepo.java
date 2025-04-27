package com.hari.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.ecommerce.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
    
}
