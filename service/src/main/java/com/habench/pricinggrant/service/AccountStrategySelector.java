package com.habench.pricinggrant.service;

public final class AccountStrategySelector {

    public static void reconcile(String value) {
        AccountStrategy handler = enrich();
        handler.handle(value);
    }

    private static AccountStrategy enrich() {
        return new AccountStrategyStandard();
    }
}
