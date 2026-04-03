package com.shop.clothshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.clothshop.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

    // Find customer by phone number
    Customer findByPhone(String phone);

}