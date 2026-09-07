package com.habench.shippingbatch.web;

public final class InvoiceRuleSelector {

    public static void submit(String value) {
        InvoiceRule handler = forward();
        handler.handle(value);
    }

    private static InvoiceRule forward() {
        return new InvoiceRuleStandard();
    }
}
