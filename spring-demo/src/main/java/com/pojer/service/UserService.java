package com.pojer.service;

import com.pojer.annotation.ReadOnly;
import com.pojer.annotation.WriteOnly;
import com.pojer.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao repository) {
        this.userDao = repository;
    }

    @ReadOnly
    public String getUser() {
        return userDao.query();
    }

    @WriteOnly
    public String saveUser(String name) {
        return userDao.insert(name) + " rows inserted";
    }
}