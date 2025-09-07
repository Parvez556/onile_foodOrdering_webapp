// package com.ROS.RestaurantOrderingSystem.Users;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "user")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String username;
//     @Column(unique = true)
//     private String email;
//     public String getPassword() {
//         return password;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
//     private String password;
//     private String phone_no;
//     private String Address;
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public String getUsername() {
//         return username;
//     }
//     public void setUsername(String username) {
//         this.username = username;
//     }
//     public String getEmail() {
//         return email;
//     }
//     public void setEmail(String email) {
//         this.email = email;
//     }
//     public String getPhone_no() {
//         return phone_no;
//     }
//     public void setPhone_no(String phone_no) {
//         this.phone_no = phone_no;
//     }
//     public String getAddress() {
//         return Address;
//     }
//     public void setAddress(String address) {
//         Address = address;
//     }
//     public User(){}
//     public User(Long id, String username, String email, String phone_no, String address,String password) {
//         this.id = id;
//         this.username = username;
//         this.email = email;
//         this.phone_no = phone_no;
//         this.password=password;
//         Address = address;
//     }
    
// }
