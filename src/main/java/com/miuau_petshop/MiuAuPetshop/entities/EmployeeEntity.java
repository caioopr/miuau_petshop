package com.miuau_petshop.MiuAuPetshop.entities;

import com.miuau_petshop.MiuAuPetshop.Enums.RolesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private RolesEnum role;
    @Column
    private LocalDate hired_at;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
