package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.entity.MapData;
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

    public MapFlyTransformer(MapData MapData) {
        this.from = MapData.getFromLon() + "," + MapData.getFromLat();
        this.to = MapData.getToLon() + "," + MapData.getToLat();
    }
}