package com.northwind.reportbind.service;

/** 报表处理策略。按渠道挑一个实现。 */
public interface BatchPlan {

    void handle(String value);
}
