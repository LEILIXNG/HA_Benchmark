package com.habench.billingrollup.service;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        RefundBuilder.refine(value);
    }
}
