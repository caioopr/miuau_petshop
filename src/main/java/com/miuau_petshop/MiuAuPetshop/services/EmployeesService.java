package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    private final EmployeesRepository employeesRepository;

    EmployeesService(EmployeesRepository employeesRepository){
        this.employeesRepository = employeesRepository;
    }

    public EmployeeEntity save(EmployeeEntity employee){
        employeesRepository.save(employee);
        return employee;
    }

    public List<EmployeeEntity> getEmployees(){
        return employeesRepository.findAll();
    }
}
