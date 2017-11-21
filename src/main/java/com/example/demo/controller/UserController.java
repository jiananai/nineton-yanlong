package com.example.demo.controller;

import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.TaotaoResult;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public TaotaoResult addUser(User user) {
        //System.out.println(user.getUsername());
        userService.insert(user);
        return TaotaoResult.ok();
    }

    @RequestMapping("/findUser/{username}")
    public String findUser(@PathVariable String username, Model model) {
        User user = userService.findUser(username);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult insert(    /*Map<String,Object> map*/User user) {
//        System.out.println(map);
//        User user=new User();
//        user.setUsername((String) map.get("username"));
//        user.setPassword((String) map.get("password"));
        userService.insert(user);
        return TaotaoResult.ok();
    }

    @RequestMapping("/user/userPage")
    @ResponseBody
    public PageResult getUserList(Integer page,Integer limit,User user){
        PageResult result =userService.findAllUser(page,limit,user);
        System.out.println(user);
        return result;
    }

    @RequestMapping("/user/delete/{userid}")
    @ResponseBody
    public TaotaoResult deleteUser(@PathVariable String userid){
        userService.deleteUser(userid);
        return TaotaoResult.ok();
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public TaotaoResult editUser(User user){
        //System.out.println(user);
        userService.editUser(user);
        return TaotaoResult.ok();
    }
}
