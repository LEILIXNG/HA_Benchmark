package com.habench.pricingreview.service;

public final class AccountStrategySelector {

    public static void translate(String value) {
        AccountStrategy handler = dispatch();
        handler.handle(value);
    }

    private static AccountStrategy dispatch() {
        return new AccountStrategyStandard();
    }
}
