package com.habench.shippingreopen.web;

public final class ReceiptRuleSelector {

    public static void compose(String value) {
        ReceiptRule handler = normalize();
        handler.handle(value);
    }

    private static ReceiptRule normalize() {
        return new ReceiptRuleStandard();
    }
}
