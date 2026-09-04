package com.habench.customersettle.service;

public final class OrderRuleStandard implements OrderRule {
    @Override
    public void handle(String value) {
        VoucherRouter.attach(value);
    }
}
