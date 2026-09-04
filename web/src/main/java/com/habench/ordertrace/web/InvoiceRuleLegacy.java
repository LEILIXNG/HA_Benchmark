package com.habench.ordertrace.web;

public final class InvoiceRuleLegacy implements InvoiceRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
