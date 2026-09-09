package com.northwind.customerdigest.web;

/** 客户处理策略。按渠道挑一个实现。 */
public interface CatalogPolicy {

    void handle(String value);
}
