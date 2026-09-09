package com.northwind.shippingposting.service;

/** 发运处理策略。按渠道挑一个实现。 */
public interface InvoicePolicy {

    void handle(String value);
}
