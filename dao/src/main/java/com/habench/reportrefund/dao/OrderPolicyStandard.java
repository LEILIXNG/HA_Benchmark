package com.habench.reportrefund.dao;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        InvoiceAssembler.route(value);
    }
}
