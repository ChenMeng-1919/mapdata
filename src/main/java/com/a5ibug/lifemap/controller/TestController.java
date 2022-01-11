package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List findAll() {
        return userService.findAllUser();
    }
}
