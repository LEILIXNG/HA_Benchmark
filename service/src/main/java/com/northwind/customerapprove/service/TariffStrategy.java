package com.northwind.customerapprove.service;

/** 客户处理策略。按渠道挑一个实现。 */
public interface TariffStrategy {

    void handle(String value);
}
