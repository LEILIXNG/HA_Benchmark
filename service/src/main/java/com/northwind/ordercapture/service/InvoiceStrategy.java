package com.northwind.ordercapture.service;

/** 订单处理策略。按渠道挑一个实现。 */
public interface InvoiceStrategy {

    void handle(String value);
}
