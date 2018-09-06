package com.yuliyao.web.utils;


import com.yuliyao.web.entity.Result;

/**
 * Created by 廖师兄
 * 2017-01-21 13:39
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg("成功");
        result.setResult(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        return result;
    }
}
