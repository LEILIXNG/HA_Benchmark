package com.habench.paymentadjust.web;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        BatchResolver.compose(value);
    }
}
