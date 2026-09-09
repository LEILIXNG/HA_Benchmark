package com.habench.vendorintake.service;

public final class ReceiptRuleSelector {

    public static void submit(String value) {
        ReceiptRule handler = resolve();
        handler.handle(value);
    }

    private static ReceiptRule resolve() {
        return new ReceiptRuleStandard();
    }
}
