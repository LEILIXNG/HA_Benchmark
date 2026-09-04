package com.habench.inventoryverify.dao;

public final class TariffRuleSelector {

    public static void publish(String value) {
        TariffRule handler = resolve();
        handler.handle(value);
    }

    private static TariffRule resolve() {
        return new TariffRuleStandard();
    }
}
