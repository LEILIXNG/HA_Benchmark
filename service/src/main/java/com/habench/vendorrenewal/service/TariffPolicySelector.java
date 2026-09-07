package com.habench.vendorrenewal.service;

public final class TariffPolicySelector {

    public static void resolve(String value) {
        TariffPolicy handler = reconcile();
        handler.handle(value);
    }

    private static TariffPolicy reconcile() {
        return new TariffPolicyStandard();
    }
}
