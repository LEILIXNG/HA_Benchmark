package com.northwind.paymentrollup.dao;

/** 支付处理策略。按渠道挑一个实现。 */
public interface BatchPlan {

    void handle(String value);
}
