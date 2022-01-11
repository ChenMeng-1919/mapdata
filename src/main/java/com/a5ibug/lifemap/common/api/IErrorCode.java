package com.a5ibug.lifemap.common.api;

/**
 * 封装API的错误码
 * Created by macro on 2019/4/19.
 */
public interface IErrorCode {
    /**
     * 获取返回状态码
     */
    long getCode();
    /**
     * 获取返回状态信息
     */
    String getMessage();
}
