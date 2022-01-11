package com.a5ibug.lifemap.transformers;

import com.a5ibug.lifemap.pojo.Map;

public class MapDotTransformer {
    private String lat;
    private String lng;

    public MapDotTransformer(Map map) {
        this.lat = map.getTo_lat();
        this.lng = map.getTo_lon();
    }
    public MapDotTransformer(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lon) {
        this.lng = lon;
    }

}
