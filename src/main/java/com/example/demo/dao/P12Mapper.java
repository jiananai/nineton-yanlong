package com.example.demo.dao;

import com.example.demo.pojo.P12;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface P12Mapper {
    List<P12> getP12List();
}
