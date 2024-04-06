package com.miuau_petshop.MiuAuPetshop.controllers;

import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.entities.ProductEntity;
import com.miuau_petshop.MiuAuPetshop.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeEntity create(@RequestBody EmployeeEntity employee ){
        return employeesService.save(employee);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeEntity> getAll(){
        return employeesService.getEmployees();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody EmployeeEntity employee ){
        employeesService.update(id,employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        employeesService.delete(id);
    }
}
