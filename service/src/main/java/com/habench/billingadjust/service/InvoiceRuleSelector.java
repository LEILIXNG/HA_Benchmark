package com.habench.billingadjust.service;

public final class InvoiceRuleSelector {

    public static void route(String value) {
        InvoiceRule handler = stage();
        handler.handle(value);
    }

    private static InvoiceRule stage() {
        return new InvoiceRuleStandard();
    }
}
