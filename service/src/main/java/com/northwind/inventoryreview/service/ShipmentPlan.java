package com.northwind.inventoryreview.service;

/** 库存处理策略。按渠道挑一个实现。 */
public interface ShipmentPlan {

    void handle(String value);
}
