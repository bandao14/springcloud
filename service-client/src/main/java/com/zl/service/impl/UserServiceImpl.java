package com.zl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zl.mapper.UserMapper;
import com.zl.model.User;
import com.zl.redis.RedisZl;
import com.zl.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;

    @Autowired
    private RedisZl redisZl;
    @Override
    public List<User> query() {
        String key="user_lst";
        if(!StringUtils.isEmpty(key)){
            List<User> user=(List<User>) redisZl.get(key);
            if(null !=user){
                System.out.println("从缓存中拿数据");
                return user;
            }
            List<User> userList=userMapper.query();
            redisZl.set(key, userList);
            System.out.println("从数据库拿数据");
            return userList;
        }
        return null;

    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
