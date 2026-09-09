package com.habench.ordercapture.web;

public final class InvoiceRuleSelector {

    public static void prepare(String value) {
        InvoiceRule handler = refine();
        handler.handle(value);
    }

    private static InvoiceRule refine() {
        return new InvoiceRuleStandard();
    }
}
