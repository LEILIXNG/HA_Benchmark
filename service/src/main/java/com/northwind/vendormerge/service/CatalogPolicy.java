package com.northwind.vendormerge.service;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface CatalogPolicy {

    void handle(String value);
}
