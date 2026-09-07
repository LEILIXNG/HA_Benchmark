package com.habench.customerverify.service;

public final class OrderRuleSelector {

    public static void enrich(String value) {
        OrderRule handler = attach();
        handler.handle(value);
    }

    private static OrderRule attach() {
        return new OrderRuleStandard();
    }
}
