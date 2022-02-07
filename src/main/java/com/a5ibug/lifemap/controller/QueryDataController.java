package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.entity.FormInLineEntity;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.MapUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/*
 * @author: cm
 * @date: Created in 2022/1/17 18:27
 * @description:
 */
@Controller
@CrossOrigin
@Slf4j
public class QueryDataController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/costpoollist2")
    public String toPages() {
        return "costpoollist2";
    }

    @GetMapping("/sqlquery")
    public String toIndex() {
        return "querydata";
    }

    @RequestMapping("/querydata")
    @ResponseBody
    public List<Map<String, Object>> test1(@RequestBody FormInLineEntity form) {
        List<Map<String, Object>> list = null;
        String sqlstring = form.getSqlstring();
        list = jdbcTemplate.queryForList(sqlstring);
        log.info("sql查询成功：{}", sqlstring);
        return list;
    }

    @RequestMapping("/downquerydata")
    @ResponseBody
    public void downQueryData(HttpServletResponse response) {
        List<Map<String, Object>> list = null;
        String sqlstring = "show tables";
        list = jdbcTemplate.queryForList(sqlstring);
        log.info("sql查询成功：{}", sqlstring);
        //封装查询结果
        List<List<Object>> resultList = new ArrayList<>();
        //查询列名
        List<String> tableNames = null;
        if (list.size() > 0) {
            Map<String, Object> stringObjectMap = list.get(0);
            Set<String> tableNameSet = stringObjectMap.keySet();
            tableNames = new ArrayList<>(tableNameSet);
        }
        //查询详细信息并封装详细信息
        for (Map<String, Object> stringObjectMap : list) {
            Collection<Object> valuesCollection = stringObjectMap.values();
            List valuesList = new ArrayList<>(valuesCollection);
            resultList.add(valuesList);
        }
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("下载结果", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream())
                    // 这里放入动态头
                    .head(this.head(tableNames)).sheet("下载结果")
                    // 当然这里数据也可以用 List<List<String>> 去传入
                    .doWrite(resultList);
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = MapUtils.newHashMap();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            try {
                String responseMessages = objectMapper.writeValueAsString(map);
                response.getWriter().println(responseMessages);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        log.info("sql下载成功：{}", sqlstring);
        //return response;
    }

    private List<List<String>> head(List<String> tableNames) {
        List<List<String>> tableNamesList = new ArrayList<List<String>>();
        for (String tableName : tableNames) {
            List<String> head = new ArrayList<String>();
            head.add(tableName);
            tableNamesList.add(head);
        }
        return tableNamesList;
    }

}
