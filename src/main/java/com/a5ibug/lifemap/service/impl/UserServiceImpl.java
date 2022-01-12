package com.a5ibug.lifemap.service.impl;

import com.a5ibug.lifemap.mapper.UserMapper;
import com.a5ibug.lifemap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List findAllUser() {
        return userMapper.findAllUser();
    }
}
