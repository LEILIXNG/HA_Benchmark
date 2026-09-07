package com.habench.catalognotice.dao;

public final class AccountStrategySelector {

    public static void assemble(String value) {
        AccountStrategy handler = refine();
        handler.handle(value);
    }

    private static AccountStrategy refine() {
        return new AccountStrategyStandard();
    }
}
