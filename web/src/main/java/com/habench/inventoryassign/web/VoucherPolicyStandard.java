package com.habench.inventoryassign.web;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        AccountEnricher.collect(value);
    }
}
