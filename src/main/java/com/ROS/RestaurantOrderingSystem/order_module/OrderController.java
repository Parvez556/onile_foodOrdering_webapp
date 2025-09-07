package com.ROS.RestaurantOrderingSystem.order_module;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", allowCredentials = "false")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Place order
@PostMapping("/place/{userId}")
public ResponseEntity<Order> placeOrder(
        @PathVariable Long userId,
        @RequestParam String address
) {
    Order order = orderService.placeOrder(userId, address);
    if (order == null) return ResponseEntity.badRequest().build();
    return ResponseEntity.ok(order);
}

@GetMapping("/user/{userId}")
public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(orderRepository.findByUserId(userId));
}

    // Get all orders (admin)
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Assign delivery agent
    @PostMapping("/assign")
    public ResponseEntity<Order> assignAgent(@RequestParam Long orderId, @RequestParam Long agentId) {
        Order order = orderService.assignDeliveryAgent(orderId, agentId);
        if (order == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }
 

    // Update status
    @PostMapping("/status")
    public ResponseEntity<Order> updateStatus(@RequestParam Long orderId, @RequestParam String status) {
        Order order = orderService.updateStatus(orderId, status);
        if (order == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }
       // ✅ Get orders by agent (👈 yaha add karo)
    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Order>> getOrdersByAgent(@PathVariable Long agentId) {
        return ResponseEntity.ok(orderService.getOrdersByAgent(agentId));
    }
    
}
