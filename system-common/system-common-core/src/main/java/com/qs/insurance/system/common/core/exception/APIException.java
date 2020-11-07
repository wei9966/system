package com.qs.insurance.system.common.core.exception;

import lombok.Data;

/**
 * Create By WeiBin on 2020/11/6 13:32
 */
@Data
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
