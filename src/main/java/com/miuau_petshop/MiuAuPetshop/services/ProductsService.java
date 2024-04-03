package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    final private ProductsRepository productsRepository;

    ProductsService(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public ProductEntity save(ProductEntity product){
        productsRepository.save(product);
        return product;
    }

    public List<ProductEntity> getProducts(){
        return productsRepository.findAll();
    }

}
