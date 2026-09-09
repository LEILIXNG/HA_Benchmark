package com.northwind.pricingrevise.web;

/** 定价处理策略。按渠道挑一个实现。 */
public interface RefundPolicy {

    void handle(String value);
}
