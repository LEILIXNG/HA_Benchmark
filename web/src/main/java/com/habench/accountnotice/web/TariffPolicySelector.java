package com.habench.accountnotice.web;

public final class TariffPolicySelector {

    public static void refine(String value) {
        TariffPolicy handler = route();
        handler.handle(value);
    }

    private static TariffPolicy route() {
        return new TariffPolicyStandard();
    }
}
