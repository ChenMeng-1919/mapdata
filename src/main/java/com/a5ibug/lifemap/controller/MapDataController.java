package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.service.MapDataService;
import com.a5ibug.lifemap.transformers.MapDotTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@CrossOrigin
@RequestMapping("/mapdata")
@Slf4j
public class MapDataController {

    @Autowired
    private MapDataService mapDataService;

    @RequestMapping("/coordinate")
    public byte[] getCoordinate() throws IOException {
        byte[] coordinate = mapDataService.getCoordinate();
        return coordinate;
    }

    /**
     * 灰机数据
     *
     * @return
     */
    @RequestMapping("/flydata")
    public List<Map<String, String>> getFlyData() {
        List<Map<String, String>> flyData = mapDataService.getFlyData();
        return flyData;
    }

    /**
     * 点点数据
     *
     * @return
     */
    @RequestMapping("/datapoint")
    public List<MapDotTransformer> gerDot() {
        List<MapDotTransformer> mapDotTransformers = mapDataService.gerDot();
        return mapDotTransformers;
    }
}
