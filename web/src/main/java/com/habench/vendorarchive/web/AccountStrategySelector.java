package com.habench.vendorarchive.web;

public final class AccountStrategySelector {

    public static void attach(String value) {
        AccountStrategy handler = assemble();
        handler.handle(value);
    }

    private static AccountStrategy assemble() {
        return new AccountStrategyStandard();
    }
}
