package com.habench.vendorsync.service;

public final class TariffPolicySelector {

    public static void register(String value) {
        TariffPolicy handler = stage();
        handler.handle(value);
    }

    private static TariffPolicy stage() {
        return new TariffPolicyStandard();
    }
}
