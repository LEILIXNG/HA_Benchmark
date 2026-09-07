package com.habench.orderdraft.web;

public final class InvoiceStrategySelector {

    public static void translate(String value) {
        InvoiceStrategy handler = collect();
        handler.handle(value);
    }

    private static InvoiceStrategy collect() {
        return new InvoiceStrategyStandard();
    }
}
