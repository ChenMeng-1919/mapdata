package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.service.MapService;
import com.a5ibug.lifemap.transformers.MapDotTransformer;
import com.a5ibug.lifemap.transformers.MapFlyTransformer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/map")
@Slf4j
public class MapController {
    @Autowired
    private MapService mapService;

    @RequestMapping("/data")
    public ResponseEntity mapJson() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mapData.json");
        InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = IOUtils.toByteArray(inputStream);
        return ResponseEntity.ok()
                .body(bytes);
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
