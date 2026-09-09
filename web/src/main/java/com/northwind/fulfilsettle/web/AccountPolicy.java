package com.northwind.fulfilsettle.web;

/** 履约处理策略。按渠道挑一个实现。 */
public interface AccountPolicy {

    void handle(String value);
}
