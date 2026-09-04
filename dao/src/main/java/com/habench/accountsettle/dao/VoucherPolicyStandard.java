package com.habench.accountsettle.dao;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        CatalogRegistry.reconcile(value);
    }
}
