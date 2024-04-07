package com.miuau_petshop.MiuAuPetshop.repositories;

import com.miuau_petshop.MiuAuPetshop.entities.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer> {


    List<OrderItemsEntity> deleteByOrder_Id(Integer order_id);
}
