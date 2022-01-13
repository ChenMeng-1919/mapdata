package com.a5ibug.lifemap.mpg;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/*
 * @author: cm
 * @date: Created in 2022/1/13 20:34
 * @description:
 */
public class MPG {
    private static final String JDBC_URL = "jdbc:mysql://8.140.29.174:3306/mapdata?characterEncoding=UTF-8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123654";

    public static void main(String[] args) {
        /**
         * 数据库相关配置
         */
        FastAutoGenerator.create(JDBC_URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("cm") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\workspace\\my-sources\\mapdata\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.a5ibug") // 设置父包名
                            .moduleName("lifemap") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\workspace\\my-sources\\mapdata\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("map_data"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
