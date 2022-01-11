package com.a5ibug.lifemap.service.impl;

import com.a5ibug.lifemap.dao.UserMapper;
import com.a5ibug.lifemap.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List findAllUser() {
        return userMapper.findAllUser();
    }
}
