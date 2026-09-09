package com.northwind.orderrefund.web;

/** 订单处理策略。按渠道挑一个实现。 */
public interface QuotePolicy {

    void handle(String value);
}
