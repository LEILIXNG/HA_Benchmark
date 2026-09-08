package com.habench.reporttrace.dao;

public final class TariffPolicySelector {

    public static void prepare(String value) {
        TariffPolicy handler = enrich();
        handler.handle(value);
    }

    private static TariffPolicy enrich() {
        return new TariffPolicyStandard();
    }
}
