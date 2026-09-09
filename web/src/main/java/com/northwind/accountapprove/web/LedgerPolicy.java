package com.northwind.accountapprove.web;

/** 账户处理策略。按渠道挑一个实现。 */
public interface LedgerPolicy {

    void handle(String value);
}
