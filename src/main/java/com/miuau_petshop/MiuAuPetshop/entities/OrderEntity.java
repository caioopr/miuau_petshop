package com.miuau_petshop.MiuAuPetshop.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private EmployeeEntity seller;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private UserEntity user;
    private Double commission;
}
