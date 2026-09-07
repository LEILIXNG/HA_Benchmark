package com.habench.reportcapture.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        PaymentBroker.register(value);
    }
}
