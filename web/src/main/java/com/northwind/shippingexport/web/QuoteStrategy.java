package com.northwind.shippingexport.web;

/** 发运处理策略。按渠道挑一个实现。 */
public interface QuoteStrategy {

    void handle(String value);
}
