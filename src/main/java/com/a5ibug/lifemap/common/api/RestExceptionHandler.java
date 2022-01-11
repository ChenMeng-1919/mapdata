package com.a5ibug.lifemap.common.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: cm
 * @since: Created in 2022/1/11 18:57
 * @description:
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     *
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return CommonResult.failed(e.getMessage());
    }
}
