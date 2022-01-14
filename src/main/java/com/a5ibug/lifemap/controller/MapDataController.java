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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/mapdata")
@Slf4j
public class MapDataController {
    @Autowired
    private MapService mapService;

    @RequestMapping("/coordinate")
    public ResponseEntity getCoordinate() throws IOException {
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
    @RequestMapping("/flydata")
    public ResponseEntity fly() {
        List<Map<String, String>> data = new ArrayList<>();
        mapService.findAllFly().forEach(item -> {
            data.add((Map<String, String>) new HashMap<>().put("from", item.getTo_lat() + "," + item.getTo_lat()));
        });
        return ResponseEntity.ok()
                .body(data);

    }

    /**
     * 点点数据
     *
     * @return
     */
    @RequestMapping("/datapoint")
    public List<MapDotTransformer> dot() {
        List<MapDotTransformer> mapTransformers = new ArrayList<>();
        mapService.findAll().forEach(item -> {
            mapTransformers.add(new MapDotTransformer(item));
        });
        return mapTransformers;
    }
}
