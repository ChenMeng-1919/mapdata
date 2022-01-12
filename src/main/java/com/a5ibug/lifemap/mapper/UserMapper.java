package com.a5ibug.lifemap.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List findAllUser();

}
