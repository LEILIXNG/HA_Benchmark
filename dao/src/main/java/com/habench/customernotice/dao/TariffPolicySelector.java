package com.habench.customernotice.dao;

public final class TariffPolicySelector {

    public static void normalize(String value) {
        TariffPolicy handler = expand();
        handler.handle(value);
    }

    private static TariffPolicy expand() {
        return new TariffPolicyStandard();
    }
}
