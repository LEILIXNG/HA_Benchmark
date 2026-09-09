package com.northwind.pricingsplit.service;

/** 定价处理策略。按渠道挑一个实现。 */
public interface PaymentStrategy {

    void handle(String value);
}
