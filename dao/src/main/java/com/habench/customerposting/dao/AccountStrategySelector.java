package com.habench.customerposting.dao;

public final class AccountStrategySelector {

    public static void prepare(String value) {
        AccountStrategy handler = normalize();
        handler.handle(value);
    }

    private static AccountStrategy normalize() {
        return new AccountStrategyStandard();
    }
}
