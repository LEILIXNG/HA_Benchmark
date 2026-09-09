package com.northwind.shippingreview.dao;

/** 发运处理策略。按渠道挑一个实现。 */
public interface ReceiptStrategy {

    void handle(String value);
}
