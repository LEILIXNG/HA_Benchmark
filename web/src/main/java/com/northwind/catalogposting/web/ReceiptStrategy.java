package com.northwind.catalogposting.web;

/** 商品处理策略。按渠道挑一个实现。 */
public interface ReceiptStrategy {

    void handle(String value);
}
