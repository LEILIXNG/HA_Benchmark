package com.habench.catalogarchive.web;

public final class InvoiceStrategySelector {

    public static void collect(String value) {
        InvoiceStrategy handler = stage();
        handler.handle(value);
    }

    private static InvoiceStrategy stage() {
        return new InvoiceStrategyStandard();
    }
}
