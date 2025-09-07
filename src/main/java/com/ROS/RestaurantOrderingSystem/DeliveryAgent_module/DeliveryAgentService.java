package com.ROS.RestaurantOrderingSystem.DeliveryAgent_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAgentService {
    
    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    public DeliveryAgent getDeliveryAgentByPhone(String phone){
        return deliveryAgentRepository.findByPhone(phone);
    }

    public DeliveryAgent getDeliveryAgentById(Long id){
        return deliveryAgentRepository.findById(id).orElse(null);
    }
}
