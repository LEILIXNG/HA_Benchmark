package com.habench.accountapprove.web;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        CatalogRegistry.enrich(value);
    }
}
