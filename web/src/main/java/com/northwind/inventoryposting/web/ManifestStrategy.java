package com.northwind.inventoryposting.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface ManifestStrategy {

    void handle(String value);
}
