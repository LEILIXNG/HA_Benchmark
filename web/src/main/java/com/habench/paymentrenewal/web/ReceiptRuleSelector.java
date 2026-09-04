package com.habench.paymentrenewal.web;

public final class ReceiptRuleSelector {

    public static void attach(String value) {
        ReceiptRule handler = normalize();
        handler.handle(value);
    }

    private static ReceiptRule normalize() {
        return new ReceiptRuleStandard();
    }
}
