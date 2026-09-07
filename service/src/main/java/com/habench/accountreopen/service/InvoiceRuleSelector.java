package com.habench.accountreopen.service;

public final class InvoiceRuleSelector {

    public static void resolve(String value) {
        InvoiceRule handler = submit();
        handler.handle(value);
    }

    private static InvoiceRule submit() {
        return new InvoiceRuleStandard();
    }
}
