package com.habench.fulfilrenewal.web;

public final class ReceiptStrategySelector {

    public static void translate(String value) {
        ReceiptStrategy handler = refine();
        handler.handle(value);
    }

    private static ReceiptStrategy refine() {
        return new ReceiptStrategyStandard();
    }
}
