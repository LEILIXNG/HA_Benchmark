package com.northwind.inventoryimport.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface BundleRule {

    void handle(String value);
}
