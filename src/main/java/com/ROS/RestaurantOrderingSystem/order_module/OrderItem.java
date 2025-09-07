package com.ROS.RestaurantOrderingSystem.order_module;



import com.ROS.RestaurantOrderingSystem.food.FoodItem;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodItem foodItem;

    private Integer quantity;

    public OrderItem() {}
    
    public OrderItem(FoodItem foodItem, Integer quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public FoodItem getFoodItem() { return foodItem; }
    public void setFoodItem(FoodItem foodItem) { this.foodItem = foodItem; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
