package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.entity.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author: cm
 * @date: Created in 2022/1/14 23:04
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapFlyTransformer {

    private String from;

    private String to;

    public MapFlyTransformer(Map map) {
        this.from = map.getFrom_lon() + "," + map.getFrom_lat();
        this.to = map.getTo_lon() + "," + map.getTo_lat();
    }
}