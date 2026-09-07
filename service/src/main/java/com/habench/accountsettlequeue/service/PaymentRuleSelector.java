package com.habench.accountsettlequeue.service;

public final class PaymentRuleSelector {

    public static void prepare(String value) {
        PaymentRule handler = enrich();
        handler.handle(value);
    }

    private static PaymentRule enrich() {
        return new PaymentRuleStandard();
    }
}
