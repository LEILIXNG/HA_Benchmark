package com.habench.customersettle.service;

public final class OrderRuleSelector {

    public static void register(String value) {
        OrderRule handler = submit();
        handler.handle(value);
    }

    private static OrderRule submit() {
        return new OrderRuleStandard();
    }
}
