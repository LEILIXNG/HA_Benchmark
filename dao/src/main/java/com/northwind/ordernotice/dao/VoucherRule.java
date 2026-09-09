package com.northwind.ordernotice.dao;

/** 订单处理策略。按渠道挑一个实现。 */
public interface VoucherRule {

    void handle(String value);
}
