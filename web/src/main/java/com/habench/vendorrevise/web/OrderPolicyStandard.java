package com.habench.vendorrevise.web;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        InvoiceComposer.enrich(value);
    }
}
