package com.northwind.reportsync.service;

/** 报表处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
