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
    @Column
    private String cnpj;
    @Column
    private String name;
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
