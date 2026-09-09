package com.northwind.paymentgrant.service;

/** 支付处理策略。按渠道挑一个实现。 */
public interface ShipmentPolicy {

    void handle(String value);
}
