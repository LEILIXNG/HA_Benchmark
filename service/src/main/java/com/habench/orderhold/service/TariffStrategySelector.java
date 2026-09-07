package com.habench.orderhold.service;

public final class TariffStrategySelector {

    public static void forward(String value) {
        TariffStrategy handler = reconcile();
        handler.handle(value);
    }

    private static TariffStrategy reconcile() {
        return new TariffStrategyStandard();
    }
}
