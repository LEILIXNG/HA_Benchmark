package com.habench.paymentbind.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        RefundBroker.collect(value);
    }
}
