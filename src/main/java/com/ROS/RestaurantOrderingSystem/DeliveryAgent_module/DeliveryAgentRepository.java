package com.ROS.RestaurantOrderingSystem.DeliveryAgent_module;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Long> {
    DeliveryAgent findByPhone(String phone);
}
