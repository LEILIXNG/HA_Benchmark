package com.habench.billingsplit.service;

public final class TariffStrategySelector {

    public static void forward(String value) {
        TariffStrategy handler = compose();
        handler.handle(value);
    }

    private static TariffStrategy compose() {
        return new TariffStrategyStandard();
    }
}
