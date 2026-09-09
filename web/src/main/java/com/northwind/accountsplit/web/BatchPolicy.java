package com.northwind.accountsplit.web;

/** 账户处理策略。按渠道挑一个实现。 */
public interface BatchPolicy {

    void handle(String value);
}
