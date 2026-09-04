package com.habench.reportapprove.web;

public final class TariffStrategySelector {

    public static void resolve(String value) {
        TariffStrategy handler = translate();
        handler.handle(value);
    }

    private static TariffStrategy translate() {
        return new TariffStrategyStandard();
    }
}
