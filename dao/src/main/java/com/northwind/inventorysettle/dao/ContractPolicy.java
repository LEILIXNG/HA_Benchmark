package com.northwind.inventorysettle.dao;

/** 库存处理策略。按渠道挑一个实现。 */
public interface ContractPolicy {

    void handle(String value);
}
