package com.miuau_petshop.MiuAuPetshop.controllers;


import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import com.miuau_petshop.MiuAuPetshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    final private ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService=productsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity create(@RequestBody ProductEntity product ){
        return productsService.save(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAll(){
        return productsService.getProducts();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody ProductEntity product ){
        productsService.update(id,product);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        return;
    }

}

