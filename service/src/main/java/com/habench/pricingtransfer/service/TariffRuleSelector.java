package com.habench.pricingtransfer.service;

public final class TariffRuleSelector {

    public static void expand(String value) {
        TariffRule handler = route();
        handler.handle(value);
    }

    private static TariffRule route() {
        return new TariffRuleStandard();
    }
}
