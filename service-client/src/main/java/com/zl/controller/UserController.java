package com.zl.controller;

import com.zl.model.User;
import com.zl.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value ="insert",method = RequestMethod.POST)
    public String insert(@RequestBody User user){
        System.out.println(user.getInfo());
        String code="";
        int count=userService.insert(user);
        if(count>=1){
            code="插入成功";
        }else {
            code="插入失败";
        }
        System.out.println(count);
        return code;
    }


}
