package com.habench.inventoryassign.service;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        AccountEnricher.collect(value);
    }
}
