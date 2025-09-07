package com.ROS.RestaurantOrderingSystem.DeliveryAgent_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/delivery_agent")
public class DeliveryAgentController {

    @Autowired
    private DeliveryAgentService deliveryAgentService;

    // Get by ID
    @GetMapping("/{id}")
    public DeliveryAgent getById(@PathVariable Long id) {
        return deliveryAgentService.getDeliveryAgentById(id);
    }

    // Get by Phone
    @GetMapping("/by-phone")
    public DeliveryAgent getByPhone(@RequestParam String phone) {
        return deliveryAgentService.getDeliveryAgentByPhone(phone);
    }
}

