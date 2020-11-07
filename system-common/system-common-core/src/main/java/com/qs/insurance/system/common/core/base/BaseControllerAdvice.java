package com.qs.insurance.system.common.core.base;

import com.qs.insurance.system.common.core.constant.enmus.ResultCode;
import com.qs.insurance.system.common.core.exception.APIException;
import com.qs.insurance.system.common.core.utils.R;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Create By WeiBin on 2020/11/6 13:31
 */
@RestControllerAdvice
public class BaseControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new R<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public R<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里返回类型是自定义响应体
        return new R<>(e.getCode(), "响应失败", e.getMsg());
    }

}
