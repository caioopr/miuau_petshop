package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.OrderEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    final private OrdersRepository ordersRepository;

    OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public OrderEntity save(OrderEntity order){
        ordersRepository.save(order);
        return order;
    }

    public List<OrderEntity> getOrders(){
        return ordersRepository.findAll();
    }
}
