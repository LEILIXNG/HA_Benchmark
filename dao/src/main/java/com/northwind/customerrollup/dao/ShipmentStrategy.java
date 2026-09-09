package com.northwind.customerrollup.dao;

/** 客户处理策略。按渠道挑一个实现。 */
public interface ShipmentStrategy {

    void handle(String value);
}
