package com.miuau_petshop.MiuAuPetshop.controllers;

import com.miuau_petshop.MiuAuPetshop.entities.OrderItemsEntity;
import com.miuau_petshop.MiuAuPetshop.services.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_items")
public class OrderItemsController {
    @Autowired
    final private OrderItemsService orderItemsService;

    OrderItemsController(OrderItemsService orderItemsService){
        this.orderItemsService = orderItemsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemsEntity> getAll(){
        return orderItemsService.getOrderItems();
    }

}
