package com.habench.paymentrevise.service;

public final class TariffRuleSelector {

    public static void expand(String value) {
        TariffRule handler = translate();
        handler.handle(value);
    }

    private static TariffRule translate() {
        return new TariffRuleStandard();
    }
}
