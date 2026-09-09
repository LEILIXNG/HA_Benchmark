package com.northwind.shippingbind.service;

/** 发运处理策略。按渠道挑一个实现。 */
public interface VoucherStrategy {

    void handle(String value);
}
