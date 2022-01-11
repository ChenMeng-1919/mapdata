package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List findAll() {
        return userService.findAllUser();
    }
}
