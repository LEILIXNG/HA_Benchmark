package com.northwind.reporttransfer.service;

/** 报表处理策略。按渠道挑一个实现。 */
public interface ContractPlan {

    void handle(String value);
}
