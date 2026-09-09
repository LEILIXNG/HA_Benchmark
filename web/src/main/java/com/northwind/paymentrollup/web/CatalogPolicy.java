package com.northwind.paymentrollup.web;

/** 支付处理策略。按渠道挑一个实现。 */
public interface CatalogPolicy {

    void handle(String value);
}
