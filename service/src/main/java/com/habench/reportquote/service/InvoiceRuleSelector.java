package com.habench.reportquote.service;

public final class InvoiceRuleSelector {

    public static void enrich(String value) {
        InvoiceRule handler = refine();
        handler.handle(value);
    }

    private static InvoiceRule refine() {
        return new InvoiceRuleStandard();
    }
}
