package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.PageUtils;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUser(String username) {
        User user = userMapper.findUserByName(username);
        return user;
    }

    @Override
    public PageResult findAllUser(Integer page, Integer limit, User user) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        if ("".equals(user.getUserid())) {
            user.setUserid(null);
        }
        if ("".equals(user.getPackageName())) {
            user.setPackageName(null);
        }

        pageUtils.setUser(user);
        List<User> list = userMapper.findAllUser(pageUtils);
        Integer count = userMapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    @Transactional
    public void deleteUser(String userid) {
        userMapper.deleteByPri(userid);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userMapper.updateByPri(user);
    }
}
