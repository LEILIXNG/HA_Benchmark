package com.habench.pricingcapture.service;

public final class RefundRuleSelector {

    public static void dispatch(String value) {
        RefundRule handler = assemble();
        handler.handle(value);
    }

    private static RefundRule assemble() {
        return new RefundRuleStandard();
    }
}
