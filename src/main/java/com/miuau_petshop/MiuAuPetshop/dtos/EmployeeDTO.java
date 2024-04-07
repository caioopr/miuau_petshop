package com.miuau_petshop.MiuAuPetshop.dtos;

import com.miuau_petshop.MiuAuPetshop.Enums.RolesEnum;

public record EmployeeDTO(RolesEnum role, Integer userID){
}
