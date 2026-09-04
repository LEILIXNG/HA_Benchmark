package com.habench.shippinglookup.dao;

public final class InvoicePlanSelector {

    public static void route(String value) {
        InvoicePlan handler = translate();
        handler.handle(value);
    }

    private static InvoicePlan translate() {
        return new InvoicePlanStandard();
    }
}
