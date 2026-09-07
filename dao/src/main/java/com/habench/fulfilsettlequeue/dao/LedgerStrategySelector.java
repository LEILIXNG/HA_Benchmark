package com.habench.fulfilsettlequeue.dao;

public final class LedgerStrategySelector {

    public static void publish(String value) {
        LedgerStrategy handler = collect();
        handler.handle(value);
    }

    private static LedgerStrategy collect() {
        return new LedgerStrategyStandard();
    }
}
