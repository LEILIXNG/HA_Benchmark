package com.habench.vendordispatch.service;

public final class ReceiptRuleSelector {

    public static void collect(String value) {
        ReceiptRule handler = dispatch();
        handler.handle(value);
    }

    private static ReceiptRule dispatch() {
        return new ReceiptRuleStandard();
    }
}
