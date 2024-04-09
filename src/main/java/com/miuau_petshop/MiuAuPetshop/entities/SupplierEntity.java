package com.miuau_petshop.MiuAuPetshop.entities;

import com.miuau_petshop.MiuAuPetshop.Enums.RolesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class SupplierEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length=18,nullable=false, unique = true)
    private String cnpj;
    @Column(length=100,nullable=false)
    private String name;
    @Column
    private Integer number;
    @Column(length=100,nullable=false)
    private String cep;
    @Column(length=100,nullable=false)
    private String street;
    @Column(length=100,nullable=false)
    private String city;
    @Column(length=100,nullable=false)
    private String state;

}
