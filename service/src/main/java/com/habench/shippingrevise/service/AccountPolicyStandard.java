package com.habench.shippingrevise.service;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ReceiptCollector.attach(value);
    }
}
