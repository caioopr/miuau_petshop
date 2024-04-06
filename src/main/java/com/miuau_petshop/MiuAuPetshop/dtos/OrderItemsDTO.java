package com.miuau_petshop.MiuAuPetshop.dtos;

public record OrderItemsDTO (
    Integer orderID,
    Integer productID,
    Integer quantity
){}
