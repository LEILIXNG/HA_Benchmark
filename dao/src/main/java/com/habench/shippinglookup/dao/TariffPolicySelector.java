package com.habench.shippinglookup.dao;

public final class TariffPolicySelector {

    public static void reconcile(String value) {
        TariffPolicy handler = collect();
        handler.handle(value);
    }

    private static TariffPolicy collect() {
        return new TariffPolicyStandard();
    }
}
