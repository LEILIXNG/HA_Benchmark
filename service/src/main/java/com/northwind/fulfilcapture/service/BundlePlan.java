package com.northwind.fulfilcapture.service;

/** 履约处理策略。按渠道挑一个实现。 */
public interface BundlePlan {

    void handle(String value);
}
