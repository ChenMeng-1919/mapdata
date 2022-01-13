package com.a5ibug.lifemap.mpg;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Properties;

/*
 * @author: cm
 * @date: Created in 2022/1/13 20:34
 * @description:
 */
public class MPG {
    /**
     * 生成代码的表名
     */
    private static final String TABLE_NAME = "map_data";
    /**
     * 数据库相关配置
     */
    private static final String JDBC_URL = "jdbc:mysql://8.140.29.174:3306/mapdata?characterEncoding=UTF-8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123654";
    /**
     * 注释显示的作者
     */
    private static final String AUTHOR = "<cm>";
    /**
     * 父包名，即springboot启动类所在包的上一层级
     */
    private static final String PARENT = "com.a5ibug";
    /**
     * 父包模块名,即springboot启动类所在包
     */
    private static final String MODULE_NAME = "lifemap";

    public static void main(String[] args) {
        /**
         * 获取项目路径
         */
        Properties properties = System.getProperties();
        String projectPath = properties.getProperty("user.dir");

        FastAutoGenerator.create(JDBC_URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT) // 设置父包名，即springboot启动类所在包的上一层级
                            .moduleName(MODULE_NAME) // 设置父包模块名,即springboot启动类所在包
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAME) // 设置需要生成的表名
                            .entityBuilder()//选择不同的构建对象才能进行不同的策略设置
                            .enableLombok()//开启lombok注解
                            .enableTableFieldAnnotation()//生成字段对应数据库的注解
                            .controllerBuilder()
                            .enableRestStyle()//开启生成@RestController 控制器
                            .mapperBuilder()
                            .enableMapperAnnotation();//开启 @Mapper 注解
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
