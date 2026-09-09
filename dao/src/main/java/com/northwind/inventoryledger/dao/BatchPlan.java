package com.northwind.inventoryledger.dao;

/** 库存处理策略。按渠道挑一个实现。 */
public interface BatchPlan {

    void handle(String value);
}
