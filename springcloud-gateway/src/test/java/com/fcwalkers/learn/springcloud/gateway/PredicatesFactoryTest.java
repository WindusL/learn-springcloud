package com.fcwalkers.learn.springcloud.gateway;

import java.time.ZonedDateTime;

public class PredicatesFactoryTest {
    public static void main(String[] args) {
        getBeforeOrAfterTime();
    }

    /**
     * 断言工厂 - Before | - After 时间获取方式
     *
     * @return
     * @date 2020/10/22 11:31 下午
     * @author Windus
     */
    public static void getBeforeOrAfterTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
