package com.habench.fulfilrefund.web;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        InvoiceCollector.assemble(value);
    }
}
