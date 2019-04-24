package com.zl.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping(value = "/file")
@RestController
public class FileController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        String filename=file.getOriginalFilename();
        String filepath="H:/1111/";
        File file1=new File(filepath+filename);
        try {
            file.transferTo(file1);
            System.out.println("文件上传完成");
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

}
