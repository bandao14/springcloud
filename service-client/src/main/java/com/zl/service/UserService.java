package com.zl.service;

import com.zl.model.User;

import java.util.List;

public interface UserService {
    List<User> query();
    int insert(User user);
}
