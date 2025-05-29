package com.hari.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.ecommerce.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Long> {
    
}
