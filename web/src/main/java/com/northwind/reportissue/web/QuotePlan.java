package com.northwind.reportissue.web;

/** 报表处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
