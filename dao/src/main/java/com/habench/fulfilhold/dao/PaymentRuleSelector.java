package com.habench.fulfilhold.dao;

public final class PaymentRuleSelector {

    public static void stage(String value) {
        PaymentRule handler = compose();
        handler.handle(value);
    }

    private static PaymentRule compose() {
        return new PaymentRuleStandard();
    }
}
