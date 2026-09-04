package com.habench.customersettle.dao;

public final class InvoicePlanSelector {

    public static void resolve(String value) {
        InvoicePlan handler = compose();
        handler.handle(value);
    }

    private static InvoicePlan compose() {
        return new InvoicePlanStandard();
    }
}
