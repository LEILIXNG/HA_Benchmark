package com.northwind.paymentbatch.service;

/** 支付处理策略。按渠道挑一个实现。 */
public interface SessionPolicy {

    void handle(String value);
}
