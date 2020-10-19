package com.fcwalkers.learn.springcloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 信息
     */
    private String message;
}
