package com.habench.fulfilmanifest.service;

public final class TariffPolicySelector {

    public static void attach(String value) {
        TariffPolicy handler = expand();
        handler.handle(value);
    }

    private static TariffPolicy expand() {
        return new TariffPolicyStandard();
    }
}
