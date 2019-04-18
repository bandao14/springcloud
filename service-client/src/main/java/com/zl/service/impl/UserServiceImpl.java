package com.zl.service.impl;

import com.zl.mapper.UserMapper;
import com.zl.model.User;
import com.zl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;

    @Override
    public List<User> query() {
        return userMapper.query();
    }
}
