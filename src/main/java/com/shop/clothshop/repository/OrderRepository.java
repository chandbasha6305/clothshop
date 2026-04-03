package com.shop.clothshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.shop.clothshop.entity.Order;

public interface OrderRepository
        extends JpaRepository<Order, Integer> {

    // Customer orders
    List<Order> findByPhone(String phone);

}