// package com.ROS.RestaurantOrderingSystem.Users;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestParam;

// @Service
// public class UserService {
//     @Autowired
//     private UserRepository userRepository;
//     public User createUser(User user){
//         return userRepository.save(user);
//     }
//    public Optional<User> getUserByid(@RequestParam Long id){
//     return userRepository.findById(id);
//    }
//     public String login(String email, String password){
//         User user=userRepository.findByEmail(email);
//         if(user!=null){
//             if(password.equals(user.getPassword())){
//                  return "Login sucessful";
//             }
//         }
//         return "Invalid credintial";
//     }
// }
