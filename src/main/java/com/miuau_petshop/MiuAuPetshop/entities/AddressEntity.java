package com.miuau_petshop.MiuAuPetshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer number;
    @Column
    private String cep;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
}
