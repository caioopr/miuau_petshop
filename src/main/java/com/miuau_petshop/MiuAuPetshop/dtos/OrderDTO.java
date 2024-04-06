package com.miuau_petshop.MiuAuPetshop.dtos;

import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import jakarta.persistence.*;

import java.util.List;

public record OrderDTO (
    Integer sellerId,
    Integer userId,
    Double commission,
    List<OrderItemsDTO> orderProducts
){}
