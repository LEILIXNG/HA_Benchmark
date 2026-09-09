package com.northwind.inventorydispatch.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
