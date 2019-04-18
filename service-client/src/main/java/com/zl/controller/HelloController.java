package com.zl.controller;

import com.zl.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class HelloController {
    private Logger log= LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public List<String> query(String one ,  String two,  String three){
        log.info("query方法传入的参数={},{},{}",one,two,three);
        List<String> list=new ArrayList();
        list.add(one);
        list.add(two);
        list.add(three);
        User user=new User();
        return list;
    }
    @RequestMapping(value = "getId",method = RequestMethod.POST)
    public String getId(@RequestBody  User user){
        log.info("getId 方法 传入的参数={}",user.toString());
        return "";
    }
}
