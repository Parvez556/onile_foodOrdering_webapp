package com.ROS.RestaurantOrderingSystem.Cart_module;



import com.ROS.RestaurantOrderingSystem.food.FoodItem;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // future me user authentication ke liye

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodItem foodItem;

    private Integer quantity;

    public Cart() {
    }

    public Cart(Long userId, FoodItem foodItem, Integer quantity) {
        this.userId = userId;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public FoodItem getFoodItem() { return foodItem; }
    public void setFoodItem(FoodItem foodItem) { this.foodItem = foodItem; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
