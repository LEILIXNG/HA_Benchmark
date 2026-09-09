package com.habench.catalogposting.web;

public final class ReceiptStrategySelector {

    public static void register(String value) {
        ReceiptStrategy handler = prepare();
        handler.handle(value);
    }

    private static ReceiptStrategy prepare() {
        return new ReceiptStrategyStandard();
    }
}
