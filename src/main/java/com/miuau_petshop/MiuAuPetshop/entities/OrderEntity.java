package com.miuau_petshop.MiuAuPetshop.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private EmployeeEntity seller;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserEntity user;
    private Double commission;
}
