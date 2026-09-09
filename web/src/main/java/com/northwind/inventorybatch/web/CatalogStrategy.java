package com.northwind.inventorybatch.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogStrategy {

    void handle(String value);
}
