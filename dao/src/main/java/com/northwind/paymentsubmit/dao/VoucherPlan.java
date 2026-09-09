package com.northwind.paymentsubmit.dao;

/** 支付处理策略。按渠道挑一个实现。 */
public interface VoucherPlan {

    void handle(String value);
}
