package com.habench.catalogcapture.service;

public final class TariffRuleSelector {

    public static void attach(String value) {
        TariffRule handler = collect();
        handler.handle(value);
    }

    private static TariffRule collect() {
        return new TariffRuleStandard();
    }
}
