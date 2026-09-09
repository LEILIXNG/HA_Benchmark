package com.northwind.vendornotice.service;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface VoucherPolicy {

    void handle(String value);
}
