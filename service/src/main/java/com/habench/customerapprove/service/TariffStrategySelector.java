package com.habench.customerapprove.service;

public final class TariffStrategySelector {

    public static void compose(String value) {
        TariffStrategy handler = translate();
        handler.handle(value);
    }

    private static TariffStrategy translate() {
        return new TariffStrategyStandard();
    }
}
