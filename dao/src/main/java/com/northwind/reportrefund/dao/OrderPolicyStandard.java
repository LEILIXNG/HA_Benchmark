package com.northwind.reportrefund.dao;

/**
 * 报表的默认处理策略。
 */
public final class OrderPolicyStandard implements OrderPolicy {

    @Override
    public void handle(String value) {
        InvoiceAssembler.route(value);
    }
}
