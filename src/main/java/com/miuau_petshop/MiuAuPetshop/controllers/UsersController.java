package com.miuau_petshop.MiuAuPetshop.controllers;

import com.miuau_petshop.MiuAuPetshop.entities.EmployeeEntity;
import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import com.miuau_petshop.MiuAuPetshop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody UserEntity user ){
        return usersService.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAll(){
        return usersService.getUsers();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserEntity update( @PathVariable Integer id,
                        @RequestBody UserEntity user ){
        return usersService.update(id,user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        usersService.delete(id);
    }

}
