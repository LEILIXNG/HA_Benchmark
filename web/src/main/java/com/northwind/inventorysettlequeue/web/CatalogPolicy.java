package com.northwind.inventorysettlequeue.web;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogPolicy {

    void handle(String value);
}
