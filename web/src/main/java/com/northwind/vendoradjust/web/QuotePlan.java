package com.northwind.vendoradjust.web;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
