package com.miuau_petshop.MiuAuPetshop.repositories;

import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {
}
