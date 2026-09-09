package com.northwind.billingdraft.web;

/** 账务处理策略。按渠道挑一个实现。 */
public interface BundlePolicy {

    void handle(String value);
}
