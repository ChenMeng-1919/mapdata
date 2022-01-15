package com.a5ibug.lifemap.service;

import com.a5ibug.lifemap.entity.AirportsData;
import com.a5ibug.lifemap.entity.MapData;
import com.a5ibug.lifemap.transformers.MapDotTransformer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 * @author: cm
 * @date: Created in 2022/1/14 23:10
 * @description:
 */
public interface MapDataService  {

    byte[] getCoordinate() throws IOException;

    List<Map<String, String>> getFlyData()  ;

    List<MapDotTransformer> gerDot();
}
