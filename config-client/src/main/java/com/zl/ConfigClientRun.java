package com.zl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ConfigClientRun {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRun.class,args);
    }


    @Value("${foo}")
    String foo;
    @Value("${test}")
    String test;
    @Value("${name}")
    String name;
    @Value("${sex}")
    String sex;
    @Value("${age}")
    String age;
    @Value("${server.port}")
    String port;
    @RequestMapping(value = "query",method = RequestMethod.GET)
    public String query(){
        System.out.println(test);
        System.out.println(foo);
        System.out.println(name);
        System.out.println(sex);
        System.out.println(age);
        System.out.println(port);
        return test;
    }
}
