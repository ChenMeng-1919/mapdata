package com.a5ibug.lifemap.service.impl;

import com.a5ibug.lifemap.mapper.MapMapper;
import com.a5ibug.lifemap.entity.Map;
import com.a5ibug.lifemap.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapMapper mapMapper;

    @Override
    public List<Map> findAllFly() {
        return mapMapper.findAllFly();
    }

    @Override
    public List<Map> findAll() {
        return mapMapper.findAll();
    }
}
