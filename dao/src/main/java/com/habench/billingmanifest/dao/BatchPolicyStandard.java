package com.habench.billingmanifest.dao;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        InvoiceAdapter.route(value);
    }
}
