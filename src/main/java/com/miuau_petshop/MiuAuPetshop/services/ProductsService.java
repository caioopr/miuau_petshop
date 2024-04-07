package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.dtos.ProductDTO;
import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.entities.SupplierEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.ProductsRepository;
import com.miuau_petshop.MiuAuPetshop.repositories.SuppliersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsService {
    @Autowired
    final private ProductsRepository productsRepository;
    @Autowired
    final private SuppliersRepository suppliersRepository;

    ProductsService(ProductsRepository productsRepository, SuppliersRepository suppliersRepository){
        this.productsRepository = productsRepository;
        this.suppliersRepository = suppliersRepository;
    }

    public ProductEntity save(ProductDTO productDTO){

        SupplierEntity supplier = suppliersRepository
                .findById(productDTO.supplierID())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        ProductEntity product = new ProductEntity();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setSupplier(supplier);

        productsRepository.save(product);
        return product;
    }

    public List<ProductEntity> getProducts(){
        return productsRepository.findAll();
    }

    @Transactional
    public void update(Integer id, ProductDTO productDTO){

        SupplierEntity supplier = suppliersRepository
                .findById(productDTO.supplierID())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        ProductEntity updatedProduct = new ProductEntity();
        updatedProduct.setSupplier(supplier);
        updatedProduct.setName(productDTO.name());
        updatedProduct.setPrice(productDTO.price());

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
