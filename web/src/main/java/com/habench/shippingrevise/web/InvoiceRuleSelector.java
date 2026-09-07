package com.habench.shippingrevise.web;

public final class InvoiceRuleSelector {

    public static void expand(String value) {
        InvoiceRule handler = submit();
        handler.handle(value);
    }

    private static InvoiceRule submit() {
        return new InvoiceRuleStandard();
    }
}
