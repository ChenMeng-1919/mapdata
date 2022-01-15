package com.a5ibug.lifemap.service.impl;

import com.a5ibug.lifemap.entity.AirportsData;
import com.a5ibug.lifemap.entity.MapData;
import com.a5ibug.lifemap.mapper.AirportsDataMapper;
import com.a5ibug.lifemap.mapper.MapDataMapper;
import com.a5ibug.lifemap.service.MapDataService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author: cm
 * @date: Created in 2022/1/14 23:10
 * @description:
 */
@Service
public class MapDataServiceImpl  implements MapDataService {

    @Autowired
    MapDataMapper mapDataMapper;
    @Override
    public byte[] getCoordinate() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mapData.json");
        InputStream inputStream = classPathResource.getInputStream();
        return IOUtils.toByteArray(inputStream);
    }

    @Override
    public List<Map<String, String>> getFlyData() {
        List<MapData> mapData = mapDataMapper.selectList(new QueryWrapper<>());
     /*   List<Map<String, String>> data = new ArrayList<>();
        mapDataMapper.li
        mapService.findAllFly().forEach(item -> {
            data.add((Map<String, String>) new HashMap<>().put("from", item.getTo_lat() + "," + item.getTo_lat()));
        });*/
        return null;
    }
}
