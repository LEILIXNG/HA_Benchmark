package com.habench.billingledger.web;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        VoucherResolver.resolve(value);
    }
}
