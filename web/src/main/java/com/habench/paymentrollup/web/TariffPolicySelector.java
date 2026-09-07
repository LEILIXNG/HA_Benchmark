package com.habench.paymentrollup.web;

public final class TariffPolicySelector {

    public static void dispatch(String value) {
        TariffPolicy handler = refine();
        handler.handle(value);
    }

    private static TariffPolicy refine() {
        return new TariffPolicyStandard();
    }
}
