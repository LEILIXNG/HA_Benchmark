package com.northwind.ordermerge.web;

/** 订单处理策略。按渠道挑一个实现。 */
public interface TariffPlan {

    void handle(String value);
}
