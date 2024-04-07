package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.dtos.EmployeeDTO;
import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.EmployeesRepository;
import com.miuau_petshop.MiuAuPetshop.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    private final EmployeesRepository employeesRepository;
    @Autowired
    final private UsersRepository usersRepository;


    EmployeesService(EmployeesRepository employeesRepository,  UsersRepository usersRepository){
        this.employeesRepository = employeesRepository;
        this.usersRepository =usersRepository;
    }

    @Transactional
    public EmployeeEntity save(EmployeeDTO employeeDTO){

        UserEntity user = usersRepository.findById(
                employeeDTO.userID()
        ).orElseThrow(()-> new RuntimeException("User not found"));

        EmployeeEntity employee = new EmployeeEntity();
        employee.setRole(employeeDTO.role());
        employee.setHired_at(LocalDate.now());
        employee.setUser(user);

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
