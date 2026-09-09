package com.northwind.billingreconcile.web;

/** 账务处理策略。按渠道挑一个实现。 */
public interface RefundStrategy {

    void handle(String value);
}
