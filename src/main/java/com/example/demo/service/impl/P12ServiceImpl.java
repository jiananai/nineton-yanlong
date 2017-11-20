package com.example.demo.service.impl;

import com.example.demo.dao.P12Mapper;
import com.example.demo.pojo.P12;
import com.example.demo.service.P12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class P12ServiceImpl implements P12Service {
    @Autowired
    private P12Mapper p12Mapper;
    @Override
    public List<P12> getP12List() {
        return p12Mapper.getP12List();
    }
}
