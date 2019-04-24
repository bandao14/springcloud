package com.zl.controller;

import com.zl.model.User;
import com.zl.service.FileService;
import com.zl.service.Hello;
import com.zl.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    public Hello hello1;

    @Autowired
    public UserService userService;

    @Autowired
    public FileService fileService;

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
    @RequestMapping(value = "upload")
    public String upload(@RequestPart("file") MultipartFile file){
        fileService.upload(file);
        return null;
    }
    @RequestMapping(value = "file")
    public ModelAndView file(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("file");
        return modelAndView;
    }
}
