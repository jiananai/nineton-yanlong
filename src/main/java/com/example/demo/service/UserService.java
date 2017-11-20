package com.example.demo.service;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.User;

public interface UserService {
    void insert(User user);

    User findUser(String username);

    PageResult findAllUser(Integer page, Integer limit, User user);

    void deleteUser(String userid);

    void editUser(User user);
}
