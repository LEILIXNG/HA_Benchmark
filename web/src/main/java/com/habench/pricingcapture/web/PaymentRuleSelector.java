package com.habench.pricingcapture.web;

public final class PaymentRuleSelector {

    public static void resolve(String value) {
        PaymentRule handler = translate();
        handler.handle(value);
    }

    private static PaymentRule translate() {
        return new PaymentRuleStandard();
    }
}
