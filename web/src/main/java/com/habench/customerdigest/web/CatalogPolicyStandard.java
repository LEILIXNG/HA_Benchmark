package com.habench.customerdigest.web;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        SessionBroker.reconcile(value);
    }
}
