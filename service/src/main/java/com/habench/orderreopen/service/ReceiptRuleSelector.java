package com.habench.orderreopen.service;

public final class ReceiptRuleSelector {

    public static void forward(String value) {
        ReceiptRule handler = translate();
        handler.handle(value);
    }

    private static ReceiptRule translate() {
        return new ReceiptRuleStandard();
    }
}
