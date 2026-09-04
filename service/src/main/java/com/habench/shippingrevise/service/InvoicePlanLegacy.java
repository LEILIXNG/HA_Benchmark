package com.habench.shippingrevise.service;

public final class InvoicePlanLegacy implements InvoicePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
