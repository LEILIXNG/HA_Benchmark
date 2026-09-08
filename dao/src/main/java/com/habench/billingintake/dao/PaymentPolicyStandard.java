package com.habench.billingintake.dao;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        QuoteCoordinator.prepare(value);
    }
}
