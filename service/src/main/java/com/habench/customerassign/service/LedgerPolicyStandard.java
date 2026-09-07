package com.habench.customerassign.service;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        CatalogService.enrich(value);
    }
}
