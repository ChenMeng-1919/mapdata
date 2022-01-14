package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.entity.Map;
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

    public MapDotTransformer(Map map) {
        this.lat = map.getTo_lat();
        this.lng = map.getTo_lon();
    }
}

