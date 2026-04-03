package com.shop.clothshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.clothshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}