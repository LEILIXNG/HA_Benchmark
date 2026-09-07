package com.habench.shippingcapture.service;

public final class RefundRuleSelector {

    public static void stage(String value) {
        RefundRule handler = expand();
        handler.handle(value);
    }

    private static RefundRule expand() {
        return new RefundRuleStandard();
    }
}
