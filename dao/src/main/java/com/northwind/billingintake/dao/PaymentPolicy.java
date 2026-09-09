package com.northwind.billingintake.dao;

/** 账务处理策略。按渠道挑一个实现。 */
public interface PaymentPolicy {

    void handle(String value);
}
