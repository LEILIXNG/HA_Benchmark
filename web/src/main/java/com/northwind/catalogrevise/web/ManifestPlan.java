package com.northwind.catalogrevise.web;

/** 商品处理策略。按渠道挑一个实现。 */
public interface ManifestPlan {

    void handle(String value);
}
