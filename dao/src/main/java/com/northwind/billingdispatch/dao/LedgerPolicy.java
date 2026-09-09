package com.northwind.billingdispatch.dao;

/** 账务处理策略。按渠道挑一个实现。 */
public interface LedgerPolicy {

    void handle(String value);
}
