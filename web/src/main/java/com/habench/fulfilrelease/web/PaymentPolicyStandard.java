package com.habench.fulfilrelease.web;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        VoucherResolver.collect(value);
    }
}
