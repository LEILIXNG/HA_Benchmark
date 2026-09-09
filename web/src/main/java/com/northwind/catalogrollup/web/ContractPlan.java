package com.northwind.catalogrollup.web;

/** 商品处理策略。按渠道挑一个实现。 */
public interface ContractPlan {

    void handle(String value);
}
