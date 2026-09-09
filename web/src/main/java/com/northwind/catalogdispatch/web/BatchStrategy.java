package com.northwind.catalogdispatch.web;

/** 商品处理策略。按渠道挑一个实现。 */
public interface BatchStrategy {

    void handle(String value);
}
