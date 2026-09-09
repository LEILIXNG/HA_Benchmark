package com.northwind.billingbind.web;

/** 账务处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
