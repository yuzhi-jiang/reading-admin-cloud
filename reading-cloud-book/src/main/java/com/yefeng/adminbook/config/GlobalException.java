package com.yefeng.adminbook.config;

import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName GlobalException.java
 * @Description TODO
 * @createTime 2022年07月17日 17:14:00
 */
@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public Result MethodArgumentTypeMismatchException(Exception e) {
        return ResultUtil.fail("参数类型错误");
    }

    @ExceptionHandler(value = Exception.class)
    public Result RuntimeException(Exception e) {
        return ResultUtil.fail("系统异常");
    }
}
