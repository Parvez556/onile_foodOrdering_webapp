package com.ROS.RestaurantOrderingSystem.Cart_module;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
  // ✅ Get cart total for a user
    @GetMapping("/total/{userId}")
    public ResponseEntity<Double> getCartTotal(@PathVariable Long userId) {
        double total = cartService.calculateTotal(userId);
        return ResponseEntity.ok(total);
    }
    // Add to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long userId,
                                          @RequestParam Long foodId,
                                          @RequestParam Integer quantity) {
        Cart cart = cartService.addToCart(userId, foodId, quantity);
        if (cart == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(cart);
    }

    // Get cart items for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    // Remove item
    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartId) {
        boolean removed = cartService.removeFromCart(cartId);
        if (removed) return ResponseEntity.ok("Item removed");
        return ResponseEntity.notFound().build();
    }

    // Clear cart (optional)
    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared");
    }
}
