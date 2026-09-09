package com.habench.accountsettlequeue.dao;

public final class AccountStrategySelector {

    public static void enrich(String value) {
        AccountStrategy handler = stage();
        handler.handle(value);
    }

    private static AccountStrategy stage() {
        return new AccountStrategyStandard();
    }
}
