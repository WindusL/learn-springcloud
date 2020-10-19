package com.fcwalkers.learn.springcloud.common.base;

import com.fcwalkers.learn.springcloud.common.enums.SysCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果基类
 *
 * @author Windus
 * @date 2017/6/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 业务对象
     */
    private T data;

    public void setEnumCode(Enum code) {
        this.code = code.toString();
        if (code.equals(SysCodeEnum.SUCCESS)) {
            this.success = true;
        }
    }
}
