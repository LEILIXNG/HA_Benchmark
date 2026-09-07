package com.habench.pricingtransfer.web;

public final class OrderRuleStandard implements OrderRule {
    @Override
    public void handle(String value) {
        InvoiceRouter.publish(value);
    }
}
