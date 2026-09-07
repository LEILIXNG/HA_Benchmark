package com.habench.fulfilissue.web;

public final class TariffRuleSelector {

    public static void merge(String value) {
        TariffRule handler = register();
        handler.handle(value);
    }

    private static TariffRule register() {
        return new TariffRuleStandard();
    }
}
