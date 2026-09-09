package com.habench.accountsettlequeue.dao;

public final class InvoicePolicySelector {

    public static void translate(String value) {
        InvoicePolicy handler = resolve();
        handler.handle(value);
    }

    private static InvoicePolicy resolve() {
        return new InvoicePolicyStandard();
    }
}
