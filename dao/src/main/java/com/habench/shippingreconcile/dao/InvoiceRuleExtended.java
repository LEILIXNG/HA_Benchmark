package com.habench.shippingreconcile.dao;

public final class InvoiceRuleExtended implements InvoiceRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
