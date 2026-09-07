package com.habench.customerverify.service;

public final class OrderRuleStandard implements OrderRule {
    @Override
    public void handle(String value) {
        SessionResolver.forward(value);
    }
}
