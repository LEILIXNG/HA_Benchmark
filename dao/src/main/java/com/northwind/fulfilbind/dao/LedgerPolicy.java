package com.northwind.fulfilbind.dao;

/** 履约处理策略。按渠道挑一个实现。 */
public interface LedgerPolicy {

    void handle(String value);
}
