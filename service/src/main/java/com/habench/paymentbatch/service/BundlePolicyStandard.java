package com.habench.paymentbatch.service;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        InvoiceCoordinator.register(value);
    }
}
