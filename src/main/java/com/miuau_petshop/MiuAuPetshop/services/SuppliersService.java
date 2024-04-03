package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.SupplierEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SuppliersService {

    @Autowired
    final private SuppliersRepository suppliersRepository;

    SuppliersService(SuppliersRepository suppliersRepository){
        this.suppliersRepository = suppliersRepository;
    }

    public SupplierEntity save(SupplierEntity supplier){
        suppliersRepository.save(supplier);
        return supplier;
    }

    public List<SupplierEntity> getSuppliers(){
        return suppliersRepository.findAll();
    }

}
