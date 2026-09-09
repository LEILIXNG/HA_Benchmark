package com.habench.accountreconcile.web;

public final class TariffPolicySelector {

    public static void resolve(String value) {
        TariffPolicy handler = enrich();
        handler.handle(value);
    }

    private static TariffPolicy enrich() {
        return new TariffPolicyStandard();
    }
}
