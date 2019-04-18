package com.zl.controller;

import com.zl.model.User;
import com.zl.service.Hello;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    public Hello hello1;

    @Autowired
    public UserService userService;

    @RequestMapping("hello")
    public String hello(){
        String  hello=hello1.hello();
        return hello;
    }

    @RequestMapping("query")
    public List query(){
        List list=hello1.query("1","2","3");
        return list;
    }

    @RequestMapping("getId")
    public String getId(){
        User user=new User();
        user.setId(1);
        user.setName("张辽");
        user.setSex("男");
        String id=hello1.getId(user);
        return "";
    }
    @RequestMapping(value = "user-query")
    public List<User> queryUser(){
        List<User> userList=userService.query();
        return userList;
    }
}
