package com.yuliyao.web.entity;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by 廖师兄
 * 2017-01-21 13:34
 */
@Data
public class Result<T> {

    /** 错误码. */
    private Integer status;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T result;


}
