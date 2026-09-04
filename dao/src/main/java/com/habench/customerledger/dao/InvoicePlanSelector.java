package com.habench.customerledger.dao;

public final class InvoicePlanSelector {

    public static void prepare(String value) {
        InvoicePlan handler = dispatch();
        handler.handle(value);
    }

    private static InvoicePlan dispatch() {
        return new InvoicePlanStandard();
    }
}
