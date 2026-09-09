package com.northwind.catalogexport.service;

/** 商品处理策略。按渠道挑一个实现。 */
public interface LedgerRule {

    void handle(String value);
}
