package com.ROS.RestaurantOrderingSystem.order_module;




import com.ROS.RestaurantOrderingSystem.Cart_module.Cart;
import com.ROS.RestaurantOrderingSystem.Cart_module.CartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderService(OrderRepository orderRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }
    // OrderService.java
   
public Order placeOrder(Long userId, String address) {
    List<Cart> cartItems = cartService.getCartByUserId(userId);
    if (cartItems.isEmpty()) return null;

    List<OrderItem> orderItems = cartItems.stream()
            .map(c -> new OrderItem(c.getFoodItem(), c.getQuantity()))
            .collect(Collectors.toList());

    Order order = new Order();
    order.setUserId(userId);
    order.setOrderTime(LocalDateTime.now());
    order.setStatus("PLACED");
    order.setOrderItems(orderItems);
    order.setDeliveryAddress(address); // 👈 set delivery address

    Order savedOrder = orderRepository.save(order);

    cartService.clearCart(userId); // clear cart after order placed
    return savedOrder;
}


   

    // Get all orders (admin dashboard)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
// OrderService.java
public List<Order> getOrdersByAgent(Long agentId) {
    return orderRepository.findByDeliveryAgentId(agentId);
}

    // Assign delivery agent
    public Order assignDeliveryAgent(Long orderId, Long agentId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) return null;

        order.setDeliveryAgentId(agentId);
        order.setStatus("ASSIGNED");
        return orderRepository.save(order);
    }

    // Update order status (DELIVERED)
    public Order updateStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) return null;

        order.setStatus(status);
        return orderRepository.save(order);
    }
}
