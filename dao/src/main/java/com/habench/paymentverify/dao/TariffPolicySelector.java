package com.habench.paymentverify.dao;

public final class TariffPolicySelector {

    public static void normalize(String value) {
        TariffPolicy handler = refine();
        handler.handle(value);
    }

    private static TariffPolicy refine() {
        return new TariffPolicyStandard();
    }
}
