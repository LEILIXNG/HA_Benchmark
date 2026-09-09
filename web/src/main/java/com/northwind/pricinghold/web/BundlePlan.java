package com.northwind.pricinghold.web;

/** 定价处理策略。按渠道挑一个实现。 */
public interface BundlePlan {

    void handle(String value);
}
