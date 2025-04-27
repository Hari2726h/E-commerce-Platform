package com.hari.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.ecommerce.entity.Review;

public interface ReviewRepo extends JpaRepository<Review,Long> {
    
}
