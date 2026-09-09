package com.northwind.customerquote.dao;

/** 客户处理策略。按渠道挑一个实现。 */
public interface BundlePolicy {

    void handle(String value);
}
