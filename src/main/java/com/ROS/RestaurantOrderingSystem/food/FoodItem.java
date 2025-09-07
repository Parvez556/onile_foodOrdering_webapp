package com.ROS.RestaurantOrderingSystem.food;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "food_items")
// public class FoodItem {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     private double price;

//     private String description;

//     private String imageUrl;  // We'll store image URL instead of saving image in DB

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }

//     public double getPrice() {
//         return price;
//     }
//     public void setPrice(double price) {
//         this.price = price;
//     }

//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getImageUrl() {
//         return imageUrl;
//     }
//     public void setImageUrl(String imageUrl) {
//         this.imageUrl = imageUrl;
//     }
// }


import jakarta.persistence.*;


@Entity
@Table(name = "food_items")
public class FoodItem {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


@Column(length = 1000)
private String description;


private Double price;


private Integer stock;


// stores the relative URL we will serve, e.g. /images/123_pizza.jpg
private String imageUrl;


public FoodItem() {}


// getters and setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }


public Double getPrice() { return price; }
public void setPrice(Double price) { this.price = price; }


public Integer getStock() { return stock; }
public void setStock(Integer stock) { this.stock = stock; }


public String getImageUrl() { return imageUrl; }
public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}