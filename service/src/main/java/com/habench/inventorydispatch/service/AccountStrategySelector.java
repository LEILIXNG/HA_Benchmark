package com.habench.inventorydispatch.service;

public final class AccountStrategySelector {

    public static void prepare(String value) {
        AccountStrategy handler = compose();
        handler.handle(value);
    }

    private static AccountStrategy compose() {
        return new AccountStrategyStandard();
    }
}
