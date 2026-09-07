package com.habench.shippingnotice.dao;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        InvoiceCollector.collect(value);
    }
}
