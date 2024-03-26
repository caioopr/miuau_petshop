package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import com.miuau_petshop.MiuAuPetshop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository ;

    UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public UserEntity save(UserEntity user){
        usersRepository.save(user);
        return user;
    }
    public List<UserEntity> getUsers(){
        return usersRepository.findAll();

    }
}
