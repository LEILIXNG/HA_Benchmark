package com.habench.paymenthold.dao;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        InvoiceAdapter.attach(value);
    }
}
