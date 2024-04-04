package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.OrderItemsEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsService {

    @Autowired
    final private OrderItemsRepository orderItemsRepository;

    OrderItemsService(OrderItemsRepository orderItemsRepository){
        this.orderItemsRepository = orderItemsRepository;
    }

    public OrderItemsEntity save(OrderItemsEntity orderItems){
        orderItemsRepository.save(orderItems);
        return orderItems;
    }

    public List<OrderItemsEntity> getOrderItems(){
        return orderItemsRepository.findAll();
    }

}
