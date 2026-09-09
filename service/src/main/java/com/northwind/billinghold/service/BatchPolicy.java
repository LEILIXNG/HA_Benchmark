package com.northwind.billinghold.service;

/** 账务处理策略。按渠道挑一个实现。 */
public interface BatchPolicy {

    void handle(String value);
}
