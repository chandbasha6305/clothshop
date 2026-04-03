package com.shop.clothshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone;
    private String address;
    private String city;
    private String pincode;
    private String status;
    private String orderDate;
    @Column(length = 5000)
    private String products;

    // ✅ Default constructor (IMPORTANT)

    
    public Order() {

    	this.status = "Placed";

    	this.orderDate =
    	java.time.LocalDate.now().toString();

    	}
    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }

    public String getProducts() {
        return products;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setProducts(String products) {
        this.products = products;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getOrderDate() {
    	return orderDate;
    	}

    	public void setOrderDate(String orderDate) {
    	this.orderDate = orderDate;
    	}

}