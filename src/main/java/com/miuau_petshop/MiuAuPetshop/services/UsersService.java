package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public UserEntity save(UserEntity user){
        return user;
    }


}
