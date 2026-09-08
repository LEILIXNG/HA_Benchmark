package com.habench.pricingrollup.web;

public final class InvoiceStrategySelector {

    public static void publish(String value) {
        InvoiceStrategy handler = collect();
        handler.handle(value);
    }

    private static InvoiceStrategy collect() {
        return new InvoiceStrategyStandard();
    }
}
