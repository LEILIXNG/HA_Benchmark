package com.northwind.reportarchive.dao;

/** 报表处理策略。按渠道挑一个实现。 */
public interface QuoteStrategy {

    void handle(String value);
}
