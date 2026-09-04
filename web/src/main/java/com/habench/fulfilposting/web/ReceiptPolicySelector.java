package com.habench.fulfilposting.web;

public final class ReceiptPolicySelector {

    public static void refine(String value) {
        ReceiptPolicy handler = merge();
        handler.handle(value);
    }

    private static ReceiptPolicy merge() {
        return new ReceiptPolicyStandard();
    }
}
