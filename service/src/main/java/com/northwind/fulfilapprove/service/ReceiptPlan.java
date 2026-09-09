package com.northwind.fulfilapprove.service;

/** 履约处理策略。按渠道挑一个实现。 */
public interface ReceiptPlan {

    void handle(String value);
}
