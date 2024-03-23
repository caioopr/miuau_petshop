package com.miuau_petshop.MiuAuPetshop.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String cpf;
    @Column
    private String name;
    @Column
    private String lastname;
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
