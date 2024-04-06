package com.miuau_petshop.MiuAuPetshop.controllers;

import com.miuau_petshop.MiuAuPetshop.dtos.OrderDTO;
import com.miuau_petshop.MiuAuPetshop.entities.OrderEntity;

import com.miuau_petshop.MiuAuPetshop.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    final private OrdersService ordersService;

    OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity create(@RequestBody OrderDTO order ){
        return ordersService.save(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> getAll(){
        return ordersService.getOrders();
    }
}
