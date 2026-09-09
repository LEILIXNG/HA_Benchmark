package com.northwind.vendortrace.web;

/**
 * 供应商的默认处理策略。
 */
public final class RefundPolicyStandard implements RefundPolicy {

    @Override
    public void handle(String value) {
        InvoiceCoordinator.attach(value);
    }
}
