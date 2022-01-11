package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.service.MapService;
import com.a5ibug.lifemap.transformers.MapDotTransformer;
import com.a5ibug.lifemap.transformers.MapFlyTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping("/map")
@CrossOrigin
public class MapController {
    @Autowired
    private MapService mapService;

    @RequestMapping("/data")
    public String MapJson() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mapData.json");
        return IOUtils.toString(new InputStreamReader(classPathResource.getInputStream(), "UTF-8"));
    }

    /**
     * 灰机数据
     *
     * @return
     */
    @RequestMapping("/fly")
    public List<MapFlyTransformer> fly() {
        List<MapFlyTransformer> mapTransformers = new ArrayList<>();
        mapService.findAllFly().forEach(item -> {
            mapTransformers.add(new MapFlyTransformer(item));
        });
        return mapTransformers;
    }

    /**
     * 点点数据
     * @return
     */
    @RequestMapping("/dot")
    public List<MapDotTransformer> dot() {
        List<MapDotTransformer> mapTransformers = new ArrayList<>();
        mapService.findAll().forEach(item -> {
            mapTransformers.add(new MapDotTransformer(item));
        });
        return mapTransformers;
    }
}
