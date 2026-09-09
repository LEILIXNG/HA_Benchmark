package com.northwind.vendorsync.service;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface AccountPolicy {

    void handle(String value);
}
