package com.habench.paymenttrace.web;

public final class OrderRuleStandard implements OrderRule {
    @Override
    public void handle(String value) {
        VoucherBroker.route(value);
    }
}
