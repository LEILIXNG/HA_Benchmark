package com.habench.paymentrenewal.web;

public final class TariffStrategySelector {

    public static void translate(String value) {
        TariffStrategy handler = enrich();
        handler.handle(value);
    }

    private static TariffStrategy enrich() {
        return new TariffStrategyStandard();
    }
}
