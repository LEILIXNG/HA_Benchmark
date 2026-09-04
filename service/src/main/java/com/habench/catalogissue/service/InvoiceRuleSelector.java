package com.habench.catalogissue.service;

public final class InvoiceRuleSelector {

    public static void merge(String value) {
        InvoiceRule handler = normalize();
        handler.handle(value);
    }

    private static InvoiceRule normalize() {
        return new InvoiceRuleStandard();
    }
}
