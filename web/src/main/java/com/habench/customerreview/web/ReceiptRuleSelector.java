package com.habench.customerreview.web;

public final class ReceiptRuleSelector {

    public static void prepare(String value) {
        ReceiptRule handler = resolve();
        handler.handle(value);
    }

    private static ReceiptRule resolve() {
        return new ReceiptRuleStandard();
    }
}
