package com.example.demo.controller;

import com.example.demo.pojo.P12;
import com.example.demo.service.P12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class P12Controller {
    @Autowired
    private P12Service p12Service;

    @RequestMapping("/p12/list")
    @ResponseBody
    public List<P12> getP12List(){
        return p12Service.getP12List();
    }
}
