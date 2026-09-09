package com.northwind.fulfilreopen.web;

/**
 * 履约的默认处理策略。
 */
public final class VoucherPolicyStandard implements VoucherPolicy {

    @Override
    public void handle(String value) {
        InvoiceComposer.publish(value);
    }
}
