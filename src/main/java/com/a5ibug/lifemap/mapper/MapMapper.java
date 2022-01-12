package com.a5ibug.lifemap.mapper;

import com.a5ibug.lifemap.entity.Map;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {

    List<Map> findAllFly();

    List<Map> findAll();
}
