package com.northwind.inventoryissue.dao;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogPlan {

    void handle(String value);
}
