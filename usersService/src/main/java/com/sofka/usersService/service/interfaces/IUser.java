package com.sofka.usersService.service.interfaces;

import com.sofka.usersService.model.Users;

import java.util.List;

public interface IUser {
    List<Users> getAll();
    Users findUser(int id);
    Users saveUser(Users user);
}
