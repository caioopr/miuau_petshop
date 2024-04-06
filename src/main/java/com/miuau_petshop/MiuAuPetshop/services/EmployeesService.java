package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
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

    public void update(Integer id, EmployeeEntity updatedEmployee){
        employeesRepository
                .findById(id)
                .map( employee -> {
                    updatedEmployee.setId(employee.getId());
                    employeesRepository.save(updatedEmployee);
                    return updatedEmployee;
                }).orElseThrow( () ->
                        new RuntimeException("Product not found!"));
    }

    public void delete(Integer id){
        employeesRepository
                .findById(id)
                .map( product -> {
                    employeesRepository.delete(product);
                    return Void.TYPE;
                }).orElseThrow( () ->
                        new RuntimeException("Product not found!"));
    }
}
