package com.habench.customerbatch.web;

public final class ReceiptRuleSelector {

    public static void collect(String value) {
        ReceiptRule handler = route();
        handler.handle(value);
    }

    private static ReceiptRule route() {
        return new ReceiptRuleStandard();
    }
}
