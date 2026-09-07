package com.habench.reportassign.web;

public final class TariffPolicySelector {

    public static void normalize(String value) {
        TariffPolicy handler = forward();
        handler.handle(value);
    }

    private static TariffPolicy forward() {
        return new TariffPolicyStandard();
    }
}
