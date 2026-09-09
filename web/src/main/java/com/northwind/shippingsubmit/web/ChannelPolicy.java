package com.northwind.shippingsubmit.web;

/** 发运处理策略。按渠道挑一个实现。 */
public interface ChannelPolicy {

    void handle(String value);
}
