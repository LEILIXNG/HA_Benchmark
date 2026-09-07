package com.habench.inventorydispatch.dao;

public final class InvoiceRuleSelector {

    public static void compose(String value) {
        InvoiceRule handler = prepare();
        handler.handle(value);
    }

    private static InvoiceRule prepare() {
        return new InvoiceRuleStandard();
    }
}
