package com.northwind.inventorymerge.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface TariffPolicy {

    void handle(String value);
}
