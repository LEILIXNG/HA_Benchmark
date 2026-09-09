package com.northwind.pricingrollup.web;

/** 定价处理策略。按渠道挑一个实现。 */
public interface InvoiceStrategy {

    void handle(String value);
}
