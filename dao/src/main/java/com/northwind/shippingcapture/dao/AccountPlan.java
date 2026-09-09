package com.northwind.shippingcapture.dao;

/** 发运处理策略。按渠道挑一个实现。 */
public interface AccountPlan {

    void handle(String value);
}
