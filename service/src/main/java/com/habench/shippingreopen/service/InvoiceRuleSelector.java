package com.habench.shippingreopen.service;

public final class InvoiceRuleSelector {

    public static void expand(String value) {
        InvoiceRule handler = assemble();
        handler.handle(value);
    }

    private static InvoiceRule assemble() {
        return new InvoiceRuleStandard();
    }
}
