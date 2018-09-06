package com.yuliyao.web.exception;

import lombok.Getter;

/**
 * @author yuliyao
 * @date 2018/9/3
 */
@Getter
public class BizException extends RuntimeException{

    private Integer code;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
