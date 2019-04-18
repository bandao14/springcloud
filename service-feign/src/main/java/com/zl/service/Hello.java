package com.zl.service;

import com.zl.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-client")
public interface Hello {
     @RequestMapping("rest/hello")
     String hello();

     @RequestMapping(value = "rest/query",method = RequestMethod.POST)
     List<String> query(@RequestParam("one") String one,@RequestParam("two") String two, @RequestParam("three") String three);

     @RequestMapping(value = "rest/getId",method = RequestMethod.POST)
     String getId(@RequestBody User user);
}
