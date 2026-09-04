package com.habench.ordertrace.web;

public final class InvoiceRuleSelector {

    public static void normalize(String value) {
        InvoiceRule handler = expand();
        handler.handle(value);
    }

    private static InvoiceRule expand() {
        return new InvoiceRuleStandard();
    }
}
