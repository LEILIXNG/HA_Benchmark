package com.northwind.orderrefund.service;

/** 订单处理策略。按渠道挑一个实现。 */
public interface BatchPlan {

    void handle(String value);
}
