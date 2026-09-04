package com.habench.vendorrelease.web;

public final class TariffStrategySelector {

    public static void expand(String value) {
        TariffStrategy handler = merge();
        handler.handle(value);
    }

    private static TariffStrategy merge() {
        return new TariffStrategyStandard();
    }
}
