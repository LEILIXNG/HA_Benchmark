package com.habench.shippinglookup.service;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        RefundCollector.translate(value);
    }
}
