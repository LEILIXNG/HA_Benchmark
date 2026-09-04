package com.habench.catalogrevise.service;

public final class InvoiceRuleSelector {

    public static void expand(String value) {
        InvoiceRule handler = publish();
        handler.handle(value);
    }

    private static InvoiceRule publish() {
        return new InvoiceRuleStandard();
    }
}
