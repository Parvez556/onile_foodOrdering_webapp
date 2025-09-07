// package com.ROS.RestaurantOrderingSystem.food_module;



// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;


// import java.util.List;

// @RestController
// @RequestMapping("/api/food")
// @CrossOrigin(origins = "*") // allow frontend access
// public class FoodController {
    

//     private final FoodService foodService;

//     public FoodController(FoodService foodService) {
//         this.foodService = foodService;
//     }
    
//     @PostMapping
//     public ResponseEntity<FoodItem> addFood(@RequestBody FoodItem foodItem) {
//         return ResponseEntity.ok(foodService.addFood(foodItem));
//     }

//     @GetMapping
//     public ResponseEntity<List<FoodItem>> getAllFood() {
//         return ResponseEntity.ok(foodService.getAllFood());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<FoodItem> getFoodById(@PathVariable Long id) {
//         return foodService.getFoodById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<FoodItem> updateFood(@PathVariable Long id, @RequestBody FoodItem foodItem) {
//         return ResponseEntity.ok(foodService.updateFood(id, foodItem));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<String> deleteFood(@PathVariable Long id) {
//         foodService.deleteFood(id);
//         return ResponseEntity.ok("Food deleted successfully!");
//     }
// }
package com.ROS.RestaurantOrderingSystem.food;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // ➡ Add Food
    @PostMapping("/add")
    public ResponseEntity<FoodItem> addFood(@RequestParam String name,
                                            @RequestParam String description,
                                            @RequestParam Double price,
                                            @RequestParam Integer stock,
                                            @RequestParam("image") MultipartFile image) throws IOException {
        FoodItem saved = foodService.addFood(name, description, price, stock, image);
        return ResponseEntity.ok(saved);
    }

    // ➡ Get All Foods
    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    // ➡ Get Food By Id
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡ Update Food
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFood(@PathVariable Long id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String description,
                                               @RequestParam(required = false) Double price,
                                               @RequestParam(required = false) Integer stock,
                                               @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        return foodService.updateFood(id, name, description, price, stock, image)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ➡ Delete Food
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        boolean deleted = foodService.deleteFood(id);
        if (deleted) {
            return ResponseEntity.ok("Food deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
