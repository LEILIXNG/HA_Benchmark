package com.habench.inventorynotice.web;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        VoucherAssembler.prepare(value);
    }
}
