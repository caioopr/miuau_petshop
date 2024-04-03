package com.miuau_petshop.MiuAuPetshop.controllers;

import com.miuau_petshop.MiuAuPetshop.entities.SupplierEntity;
import com.miuau_petshop.MiuAuPetshop.services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
    @Autowired
    final private SuppliersService suppliersService;

    SuppliersController(SuppliersService suppliersService){
        this.suppliersService = suppliersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierEntity create(@RequestBody SupplierEntity supplier ){
        return suppliersService.save(supplier);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierEntity> getAll(){
        return suppliersService.getSuppliers();
    }

}
