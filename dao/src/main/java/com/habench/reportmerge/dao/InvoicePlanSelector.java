package com.habench.reportmerge.dao;

public final class InvoicePlanSelector {

    public static void compose(String value) {
        InvoicePlan handler = reconcile();
        handler.handle(value);
    }

    private static InvoicePlan reconcile() {
        return new InvoicePlanStandard();
    }
}
