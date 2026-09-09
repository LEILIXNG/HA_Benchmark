package com.northwind.fulfilassign.service;

/** 履约处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
