package com.northwind.pricingexport.web;

/** 定价处理策略。按渠道挑一个实现。 */
public interface LedgerStrategy {

    void handle(String value);
}
