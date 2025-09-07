// package com.ROS.RestaurantOrderingSystem.Users;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;


// @RestController
// @CrossOrigin(origins = "*")
// @RequestMapping("/api")
// public class UserController {
//     @Autowired
//     private UserService userService;
//     @PostMapping("/register")
//     public User registerUser(@RequestBody User user){
//         return userService.createUser(user);
//     }
//     @PostMapping("login")
//     public String loginUser(@RequestBody LoginRequest loginRequest) {
//         //TODO: process POST request
//         return userService.login(loginRequest.getEmail(),loginRequest.getPassword());
        
//     }
//     @GetMapping("/user/{id}")
//     public Optional<User> getMethodName(@PathVariable Long id) {
//         return userService.getUserByid(id);
//     }
    
// }
