package com.habench.billingsettlequeue.dao;

public final class TariffRuleSelector {

    public static void collect(String value) {
        TariffRule handler = register();
        handler.handle(value);
    }

    private static TariffRule register() {
        return new TariffRuleStandard();
    }
}
