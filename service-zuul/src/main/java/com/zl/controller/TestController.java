package com.zl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test")
@RestController
public class TestController {

    @RequestMapping("/zzz")
    public String hello(){

        return "1111";
    }
}
