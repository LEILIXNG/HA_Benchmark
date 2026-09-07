package com.habench.pricingrefund.dao;

public final class ReceiptStrategySelector {

    public static void stage(String value) {
        ReceiptStrategy handler = submit();
        handler.handle(value);
    }

    private static ReceiptStrategy submit() {
        return new ReceiptStrategyStandard();
    }
}
