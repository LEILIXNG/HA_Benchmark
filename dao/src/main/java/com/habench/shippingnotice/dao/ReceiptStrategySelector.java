package com.habench.shippingnotice.dao;

public final class ReceiptStrategySelector {

    public static void normalize(String value) {
        ReceiptStrategy handler = route();
        handler.handle(value);
    }

    private static ReceiptStrategy route() {
        return new ReceiptStrategyStandard();
    }
}
