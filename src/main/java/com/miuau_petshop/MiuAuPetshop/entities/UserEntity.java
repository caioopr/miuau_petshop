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
@Table(name = "users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length=14, nullable=false, unique = true)
    private String cpf;
    @Column(length=100,nullable=false)
    private String name;
    @Column(length=100,nullable=false)
    private String lastname;
    @Column
    private Integer number;
    @Column(length=9,nullable=false)
    private String cep;
    @Column(length=100,nullable=false)
    private String street;
    @Column(length=100,nullable=false)
    private String city;
    @Column(length=100,nullable=false)
    private String state;
}
