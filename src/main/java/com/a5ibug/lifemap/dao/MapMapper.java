package com.a5ibug.lifemap.dao;

import com.a5ibug.lifemap.pojo.Map;

import java.util.List;

public interface MapMapper {
    public List<Map> findAllFly();

    public List<Map> findAll();
}
