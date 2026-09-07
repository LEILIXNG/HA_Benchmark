package com.habench.shippingcapture.service;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        VoucherCollector.attach(value);
    }
}
