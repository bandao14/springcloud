package com.zl.service;

import com.zl.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-client")
public interface UserService {

    @RequestMapping(value = "user/query")
    List<User> query();
}
