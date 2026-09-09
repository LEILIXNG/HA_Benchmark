package com.northwind.vendorarchive.web;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface AccountStrategy {

    void handle(String value);
}
