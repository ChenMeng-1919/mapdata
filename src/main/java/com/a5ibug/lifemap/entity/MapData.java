package com.a5ibug.lifemap.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 地图数据
 * </p>
 *
 * @author <cm>
 * @since 2022-01-14
 */
@Getter
@Setter
@TableName("map_data")
public class MapData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    /**
     * 0 飞机 1火车 2高铁 3汽车
     */
    @TableField("type")
    private String type;

    @TableField("from_lat")
    private String fromLat;

    @TableField("from_lon")
    private String fromLon;

    @TableField("to_lat")
    private String toLat;

    @TableField("to_lon")
    private String toLon;

    @TableField("other")
    private String other;

    @TableField("date")
    private LocalDate date;


}
