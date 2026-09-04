package com.habench.vendoradjust.service;

public final class TariffPolicySelector {

    public static void normalize(String value) {
        TariffPolicy handler = prepare();
        handler.handle(value);
    }

    private static TariffPolicy prepare() {
        return new TariffPolicyStandard();
    }
}
