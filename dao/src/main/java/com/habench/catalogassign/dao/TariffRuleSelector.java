package com.habench.catalogassign.dao;

public final class TariffRuleSelector {

    public static void publish(String value) {
        TariffRule handler = collect();
        handler.handle(value);
    }

    private static TariffRule collect() {
        return new TariffRuleStandard();
    }
}
