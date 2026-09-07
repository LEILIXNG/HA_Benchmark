package com.habench.vendorrelease.service;

public final class InvoiceRuleSelector {

    public static void enrich(String value) {
        InvoiceRule handler = attach();
        handler.handle(value);
    }

    private static InvoiceRule attach() {
        return new InvoiceRuleStandard();
    }
}
