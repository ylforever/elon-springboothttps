package com.elon.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口结果模型
 *
 * @author elon
 * @since 2021-11-14
 */
@Getter
@Setter
public class Result<T> {
    /**
     * 成功错误码
     */
    private static final int SUCCESS_CODE = 1;

    /**
     * 失败错误码
     */
    private static final int FAIL_CODE = 1;

    /**
     * 错误码
     */
    private int code = 0;

    /**
     * 数据体
     */
    private T data = null;

    /**
     * 错误信息
     */
    private String errorInfo = "";

    /**
     * 创建成功的返回结果
     *
     * @param data 数据
     * @param <T> 泛型
     * @return 结果模型
     */
    public static <T> Result<T> createSuccessResult(T data) {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
}
