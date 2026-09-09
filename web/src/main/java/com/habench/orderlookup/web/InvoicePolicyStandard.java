package com.habench.orderlookup.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        SessionCoordinator.enrich(value);
    }
}
