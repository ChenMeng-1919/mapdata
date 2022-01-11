package com.a5ibug.lifemap.pojo;


import java.io.Serializable;
import java.util.Date;

public class Map implements Serializable {
    private Integer id;
    private Integer user_id;
    private String type;
    private String from_lat;
    private String to_lat;
    private String from_lon;
    private String to_lon;
    private String other;
    private Date date;

    public String getFrom_lat() {
        return from_lat;
    }

    public void setFrom_lat(String from_lat) {
        this.from_lat = from_lat;
    }

    public String getTo_lat() {
        return to_lat;
    }

    public void setTo_lat(String to_lat) {
        this.to_lat = to_lat;
    }

    public String getFrom_lon() {
        return from_lon;
    }

    public void setFrom_lon(String from_lon) {
        this.from_lon = from_lon;
    }

    public String getTo_lon() {
        return to_lon;
    }

    public void setTo_lon(String to_lon) {
        this.to_lon = to_lon;
    }



    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", type='" + type + '\'' +
                ", from_lat='" + from_lat + '\'' +
                ", to_lat='" + to_lat + '\'' +
                ", from_lon='" + from_lon + '\'' +
                ", to_lon='" + to_lon + '\'' +
                ", other='" + other + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
