package com.northwind.inventoryreconcile.dao;

/** 库存处理策略。按渠道挑一个实现。 */
public interface SessionPlan {

    void handle(String value);
}
