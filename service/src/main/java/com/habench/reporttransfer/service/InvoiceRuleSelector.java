package com.habench.reporttransfer.service;

public final class InvoiceRuleSelector {

    public static void forward(String value) {
        InvoiceRule handler = reconcile();
        handler.handle(value);
    }

    private static InvoiceRule reconcile() {
        return new InvoiceRuleStandard();
    }
}
