package com.miuau_petshop.MiuAuPetshop.repositories;

import com.miuau_petshop.MiuAuPetshop.entities.OrderEntity;
import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, Integer> {
}