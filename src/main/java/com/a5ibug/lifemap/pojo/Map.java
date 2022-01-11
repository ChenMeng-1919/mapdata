package com.a5ibug.lifemap.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
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

}
