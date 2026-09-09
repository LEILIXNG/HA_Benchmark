package com.northwind.reportdispatch.dao;

/** 报表处理策略。按渠道挑一个实现。 */
public interface BundlePlan {

    void handle(String value);
}
