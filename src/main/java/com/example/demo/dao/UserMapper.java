package com.example.demo.dao;

import com.example.demo.pojo.PageUtils;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    User findUserByName(String username);

    List<User> findAllUser(PageUtils pageUtils);

    Integer count(PageUtils user);

    void deleteByPri(String userid);

    void updateByPri(User user);
}
