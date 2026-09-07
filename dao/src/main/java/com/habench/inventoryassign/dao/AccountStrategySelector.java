package com.habench.inventoryassign.dao;

public final class AccountStrategySelector {

    public static void stage(String value) {
        AccountStrategy handler = publish();
        handler.handle(value);
    }

    private static AccountStrategy publish() {
        return new AccountStrategyStandard();
    }
}
