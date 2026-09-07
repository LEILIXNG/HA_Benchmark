package com.habench.shippingbatch.web;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        PaymentResolver.enrich(value);
    }
}
