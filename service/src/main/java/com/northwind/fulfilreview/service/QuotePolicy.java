package com.northwind.fulfilreview.service;

/** 履约处理策略。按渠道挑一个实现。 */
public interface QuotePolicy {

    void handle(String value);
}
