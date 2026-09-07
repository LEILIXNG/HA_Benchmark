package com.habench.customerassign.service;

public final class InvoiceStrategySelector {

    public static void reconcile(String value) {
        InvoiceStrategy handler = submit();
        handler.handle(value);
    }

    private static InvoiceStrategy submit() {
        return new InvoiceStrategyStandard();
    }
}
