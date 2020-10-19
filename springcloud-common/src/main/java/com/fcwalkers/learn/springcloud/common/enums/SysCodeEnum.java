package com.fcwalkers.learn.springcloud.common.enums;

/**
 * 状态码
 *
 * @author Windus
 * @date 2017/6/16
 */
public enum SysCodeEnum {
    /**
     * 编码列表
     */
    SUCCESS("成功"), FAIL("失败"),
    INVALID_PARAM("无效参数"), NO_AUTHORITY("权限验证失败");

    SysCodeEnum(String message) {
        this.message = message;
    }

    /**
     * 编码描述
     */
    private String message;

    public String getMessage() {
        return message;
    }
}
