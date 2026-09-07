package com.habench.orderlookup.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        RefundCoordinator.refine(value);
    }
}
