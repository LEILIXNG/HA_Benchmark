package com.habench.vendorassign.web;

public final class TariffStrategySelector {

    public static void collect(String value) {
        TariffStrategy handler = normalize();
        handler.handle(value);
    }

    private static TariffStrategy normalize() {
        return new TariffStrategyStandard();
    }
}
