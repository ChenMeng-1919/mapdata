package com.a5ibug.lifemap.controller;

import com.a5ibug.lifemap.common.utils.ThrowableUtils;
import com.a5ibug.lifemap.entity.FormInLineEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/querydata")
    public String toIndex() {
        return "querydata";
    }

    @RequestMapping("/querydata")
    @ResponseBody
    public List<Map<String, Object>> test1(@RequestBody FormInLineEntity form) {
        List<Map<String, Object>> list = null;
        try {
            String sqlstring = form.getSqlstring();
            list = jdbcTemplate.queryForList(sqlstring);
            log.info("sql查询成功：{}",sqlstring);
        } catch (DataAccessException e) {
            e.printStackTrace();
            //获取异常详细信息
            String message = e.getMessage();
            //获取异常堆栈
            String stackTrace = ThrowableUtils.getStackTrace(e);
            log.info("查询异常，sql执行错误，异常提示为：{}",message);
        }
        return list;
    }
}
