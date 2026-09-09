package com.northwind.catalogtransfer.web;

/** 商品处理策略。按渠道挑一个实现。 */
public interface RefundRule {

    void handle(String value);
}
