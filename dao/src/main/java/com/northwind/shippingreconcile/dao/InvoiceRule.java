package com.northwind.shippingreconcile.dao;

/** 发运处理策略。按渠道挑一个实现。 */
public interface InvoiceRule {

    void handle(String value);
}
