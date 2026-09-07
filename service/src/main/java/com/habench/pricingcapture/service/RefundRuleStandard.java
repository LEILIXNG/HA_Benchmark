package com.habench.pricingcapture.service;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        OrderAdapter.forward(value);
    }
}
