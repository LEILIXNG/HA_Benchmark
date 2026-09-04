package com.habench.reporttransfer.service;

public final class TariffPolicySelector {

    public static void attach(String value) {
        TariffPolicy handler = reconcile();
        handler.handle(value);
    }

    private static TariffPolicy reconcile() {
        return new TariffPolicyStandard();
    }
}
