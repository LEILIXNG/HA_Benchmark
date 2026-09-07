package com.habench.inventoryissue.service;

public final class AccountStrategySelector {

    public static void route(String value) {
        AccountStrategy handler = stage();
        handler.handle(value);
    }

    private static AccountStrategy stage() {
        return new AccountStrategyStandard();
    }
}
