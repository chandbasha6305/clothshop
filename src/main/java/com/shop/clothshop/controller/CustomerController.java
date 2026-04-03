package com.shop.clothshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.clothshop.entity.Customer;
import com.shop.clothshop.repository.CustomerRepository;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Register Customer

    @PostMapping("/register")
    public Customer registerCustomer(
            @RequestBody Customer customer) {

        return customerRepository.save(customer);

    }

    // Login Customer using phone

    @GetMapping("/login/{phone}")
    public Customer loginCustomer(
            @PathVariable String phone) {

        return customerRepository.findByPhone(phone);

    }

}