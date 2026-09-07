package com.habench.pricingsplit.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        CatalogFacade.normalize(value);
    }
}
