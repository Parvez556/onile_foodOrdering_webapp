package com.ROS.RestaurantOrderingSystem.order_module;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // customer id

    private LocalDateTime orderTime;

    private String status; // PLACED, ASSIGNED, DELIVERED


    // private Long deliveryAgentId; // null until assigned
// Order.java
    private String deliveryAddress;
 

    public String getDeliveryAddress() {
    return deliveryAddress;
}

public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
}
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    private Long deliveryAgentId;

    public Order() {
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getDeliveryAgentId() { return deliveryAgentId; }
    public void setDeliveryAgentId(Long deliveryAgentId) { this.deliveryAgentId = deliveryAgentId; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
}
