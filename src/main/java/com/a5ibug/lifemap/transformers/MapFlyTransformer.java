package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.pojo.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
