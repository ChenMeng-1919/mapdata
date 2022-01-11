package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.pojo.Map;

public class MapFlyTransformer {
    public MapFlyTransformer() {

    }

    public MapFlyTransformer(Map map) {
        this.from = map.getFrom_lon() + "," + map.getFrom_lat();
        this.to = map.getTo_lon() + "," + map.getTo_lat();
    }

    public MapFlyTransformer(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    private String from;
    private String to;
}
