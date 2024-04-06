package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void update(Integer id, ProductEntity updatedProduct){
        productsRepository
                .findById(id)
                .map( productItem -> {
                    updatedProduct.setId(productItem.getId());
                    productsRepository.save(updatedProduct);
                    return updatedProduct;
                }).orElseThrow( () ->
                        new RuntimeException("Product not found!"));
    }

    public void delete(Integer id){
        productsRepository
                .findById(id)
                .map( product -> {
                    productsRepository.delete(product);
                    return Void.TYPE;
                }).orElseThrow( () ->
                        new RuntimeException("Product not found!"));
    }

}
