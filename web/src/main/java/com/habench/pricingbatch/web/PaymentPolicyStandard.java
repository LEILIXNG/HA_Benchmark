package com.habench.pricingbatch.web;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        VoucherCollector.enrich(value);
    }
}
