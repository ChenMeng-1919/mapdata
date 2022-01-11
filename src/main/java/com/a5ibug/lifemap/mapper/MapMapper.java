package com.a5ibug.lifemap.mapper;

import com.a5ibug.lifemap.entity.Map;

import java.util.List;

public interface MapMapper {

    List<Map> findAllFly();

    List<Map> findAll();
}
