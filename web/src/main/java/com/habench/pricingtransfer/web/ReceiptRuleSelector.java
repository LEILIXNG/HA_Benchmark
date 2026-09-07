package com.habench.pricingtransfer.web;

public final class ReceiptRuleSelector {

    public static void attach(String value) {
        ReceiptRule handler = enrich();
        handler.handle(value);
    }

    private static ReceiptRule enrich() {
        return new ReceiptRuleStandard();
    }
}
