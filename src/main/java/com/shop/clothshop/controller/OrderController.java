package com.shop.clothshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.shop.clothshop.entity.Order;
import com.shop.clothshop.repository.OrderRepository;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Place Order

    @PostMapping("/placeOrder")
    public Order placeOrder(
            @RequestBody Order order) {

        return orderRepository.save(order);

    }

    // Customer Orders

    @GetMapping("/orders/{phone}")
    public List<Order> getOrdersByPhone(
            @PathVariable String phone) {

        return orderRepository.findByPhone(phone);

    }

    // Admin Orders

    @GetMapping("/orders")
    public List<Order> getAllOrders() {

        return orderRepository.findAll();

    }

    // Cancel Order

    @DeleteMapping("/cancelOrder/{id}")
    public void cancelOrder(
            @PathVariable int id) {

        orderRepository.deleteById(id);

    }

    // Update Status

    @PutMapping("/updateStatus/{id}")
    public Order updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        Order order =
                orderRepository.findById(id).orElse(null);

        if (order != null) {

            order.setStatus(status);

            return orderRepository.save(order);

        }

        return null;

    }

}