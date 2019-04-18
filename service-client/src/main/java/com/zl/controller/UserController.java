package com.zl.controller;

import com.zl.model.User;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public String query(){
        List<User> list=userService.query();
        list.forEach(t -> System.out.println(t.toString()));
        return "";
    }

}
