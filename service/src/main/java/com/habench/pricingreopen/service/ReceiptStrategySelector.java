package com.habench.pricingreopen.service;

public final class ReceiptStrategySelector {

    public static void translate(String value) {
        ReceiptStrategy handler = reconcile();
        handler.handle(value);
    }

    private static ReceiptStrategy reconcile() {
        return new ReceiptStrategyStandard();
    }
}
