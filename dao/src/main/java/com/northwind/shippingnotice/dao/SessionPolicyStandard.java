package com.northwind.shippingnotice.dao;

/**
 * 发运的默认处理策略。
 */
public final class SessionPolicyStandard implements SessionPolicy {

    @Override
    public void handle(String value) {
        InvoiceCollector.collect(value);
    }
}
