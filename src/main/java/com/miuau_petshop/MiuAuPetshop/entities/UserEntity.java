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
    @OneToOne
    @JoinColumn(name="address_id")
    private AddressEntity address;

}
