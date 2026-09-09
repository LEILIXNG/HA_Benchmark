package com.habench.ordercapture.service;

public final class InvoiceStrategySelector {

    public static void publish(String value) {
        InvoiceStrategy handler = dispatch();
        handler.handle(value);
    }

    private static InvoiceStrategy dispatch() {
        return new InvoiceStrategyStandard();
    }
}
