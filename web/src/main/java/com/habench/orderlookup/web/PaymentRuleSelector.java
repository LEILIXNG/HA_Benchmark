package com.habench.orderlookup.web;

public final class PaymentRuleSelector {

    public static void publish(String value) {
        PaymentRule handler = translate();
        handler.handle(value);
    }

    private static PaymentRule translate() {
        return new PaymentRuleStandard();
    }
}
