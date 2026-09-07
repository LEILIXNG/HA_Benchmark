package com.habench.vendorrelease.service;

public final class TariffStrategySelector {

    public static void expand(String value) {
        TariffStrategy handler = merge();
        handler.handle(value);
    }

    private static TariffStrategy merge() {
        return new TariffStrategyStandard();
    }
}
