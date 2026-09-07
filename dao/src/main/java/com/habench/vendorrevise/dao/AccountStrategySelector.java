package com.habench.vendorrevise.dao;

public final class AccountStrategySelector {

    public static void submit(String value) {
        AccountStrategy handler = collect();
        handler.handle(value);
    }

    private static AccountStrategy collect() {
        return new AccountStrategyStandard();
    }
}
