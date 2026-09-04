package com.habench.billingreconcile.service;

public final class TariffStrategySelector {

    public static void merge(String value) {
        TariffStrategy handler = translate();
        handler.handle(value);
    }

    private static TariffStrategy translate() {
        return new TariffStrategyStandard();
    }
}
