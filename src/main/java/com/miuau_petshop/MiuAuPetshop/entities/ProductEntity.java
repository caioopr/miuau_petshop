package com.miuau_petshop.MiuAuPetshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length=100,nullable=false)
    private String name;
    @Column
    private Double price;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;
}
