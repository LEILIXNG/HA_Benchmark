package com.habench.billingmerge.service;

public final class ReceiptRuleSelector {

    public static void route(String value) {
        ReceiptRule handler = refine();
        handler.handle(value);
    }

    private static ReceiptRule refine() {
        return new ReceiptRuleStandard();
    }
}
