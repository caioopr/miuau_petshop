package com.miuau_petshop.MiuAuPetshop.repositories;

import com.miuau_petshop.MiuAuPetshop.entities.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer> {
}
