package com.northwind.paymentsplit.web;

/** 支付处理策略。按渠道挑一个实现。 */
public interface VoucherRule {

    void handle(String value);
}
