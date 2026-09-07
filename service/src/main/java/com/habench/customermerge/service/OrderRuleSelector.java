package com.habench.customermerge.service;

public final class OrderRuleSelector {

    public static void register(String value) {
        OrderRule handler = prepare();
        handler.handle(value);
    }

    private static OrderRule prepare() {
        return new OrderRuleStandard();
    }
}
