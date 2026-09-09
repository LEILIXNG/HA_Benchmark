package com.habench.fulfilledger.web;

public final class TariffPolicySelector {

    public static void register(String value) {
        TariffPolicy handler = dispatch();
        handler.handle(value);
    }

    private static TariffPolicy dispatch() {
        return new TariffPolicyStandard();
    }
}
