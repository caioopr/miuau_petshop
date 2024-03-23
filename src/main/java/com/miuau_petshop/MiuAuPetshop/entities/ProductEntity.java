package com.miuau_petshop.MiuAuPetshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;
}
