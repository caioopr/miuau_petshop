package com.miuau_petshop.MiuAuPetshop.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //@JsonIgnore
    @ManyToOne ( fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private EmployeeEntity seller;
    //@JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    private UserEntity user;
    private Double commission;
}
