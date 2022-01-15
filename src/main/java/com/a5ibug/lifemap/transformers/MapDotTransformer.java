package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.entity.MapData;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @author: cm
 * @date: Created in 2022/1/14 23:03
 * @description:
 */
@Data
@AllArgsConstructor
public class MapDotTransformer {
    private String lat;
    private String lng;

    public MapDotTransformer(MapData mapData) {
        this.lat = mapData.getToLat();
        this.lng = mapData.getToLon();
    }
}

