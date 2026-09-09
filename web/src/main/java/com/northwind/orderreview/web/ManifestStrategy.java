package com.northwind.orderreview.web;

/** 订单处理策略。按渠道挑一个实现。 */
public interface ManifestStrategy {

    void handle(String value);
}
