package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    private Logger log= LoggerFactory.getLogger(PageController.class);
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

}
