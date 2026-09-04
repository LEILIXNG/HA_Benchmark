package com.habench.fulfilimport.web;

public final class TariffStrategySelector {

    public static void compose(String value) {
        TariffStrategy handler = assemble();
        handler.handle(value);
    }

    private static TariffStrategy assemble() {
        return new TariffStrategyStandard();
    }
}
