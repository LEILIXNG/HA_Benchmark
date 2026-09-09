package com.northwind.paymentintake.dao;

/** 支付处理策略。按渠道挑一个实现。 */
public interface QuotePolicy {

    void handle(String value);
}
