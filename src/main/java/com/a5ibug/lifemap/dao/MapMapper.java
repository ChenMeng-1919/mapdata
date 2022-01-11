package com.a5ibug.lifemap.dao;

import com.a5ibug.lifemap.pojo.Map;

import java.util.List;

public interface MapMapper {

    List<Map> findAllFly();

    List<Map> findAll();
}
