package com.ROS.RestaurantOrderingSystem.Cart_module;



import org.springframework.stereotype.Service;

import com.ROS.RestaurantOrderingSystem.food.FoodItem;
import com.ROS.RestaurantOrderingSystem.food.FoodService;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final FoodService foodService;

    public CartService(CartRepository cartRepository, FoodService foodService) {
        this.cartRepository = cartRepository;
        this.foodService = foodService;
    }
// CartService.java
public double calculateTotal(Long userId) {
    List<Cart> cartItems = getCartByUserId(userId);
    return cartItems.stream()
            .mapToDouble(c -> c.getFoodItem().getPrice() * c.getQuantity())
            .sum();
}

    // Add item to cart
    public Cart addToCart(Long userId, Long foodId, Integer quantity) {
        Optional<FoodItem> foodOpt = foodService.getFoodById(foodId);
        if (foodOpt.isEmpty()) return null;

        // Check if item already in cart, increase quantity
        List<Cart> userCart = cartRepository.findByUserId(userId);
        for (Cart c : userCart) {
            if (c.getFoodItem().getId().equals(foodId)) {
                c.setQuantity(c.getQuantity() + quantity);
                return cartRepository.save(c);
            }
        }

        Cart cartItem = new Cart(userId, foodOpt.get(), quantity);
        return cartRepository.save(cartItem);
    }

    // Get cart items for user
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    // Remove item from cart
    public boolean removeFromCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cartRepository.delete(cart.get());
            return true;
        }
        return false;
    }

    // Clear cart (after order placed)
    public void clearCart(Long userId) {
        List<Cart> userCart = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(userCart);
    }
}
