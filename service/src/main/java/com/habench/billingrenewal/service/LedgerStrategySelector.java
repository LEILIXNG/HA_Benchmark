package com.habench.billingrenewal.service;

public final class LedgerStrategySelector {

    public static void register(String value) {
        LedgerStrategy handler = expand();
        handler.handle(value);
    }

    private static LedgerStrategy expand() {
        return new LedgerStrategyStandard();
    }
}
