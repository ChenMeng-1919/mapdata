package com.a5ibug.lifemap.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author <cm>
 * @since 2022-01-15
 */
@Getter
@Setter
@TableName("airports_data")
public class AirportsData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("ident")
    private String ident;

    @TableField("name")
    private String name;

    @TableField("latitude_deg")
    private String latitudeDeg;

    @TableField("longitude_deg")
    private String longitudeDeg;

    @TableField("continent")
    private String continent;

    @TableField("iso_country")
    private String isoCountry;

    @TableField("iso_region")
    private String isoRegion;


}
