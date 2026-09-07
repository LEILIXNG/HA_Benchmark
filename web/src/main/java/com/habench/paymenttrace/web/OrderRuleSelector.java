package com.habench.paymenttrace.web;

public final class OrderRuleSelector {

    public static void publish(String value) {
        OrderRule handler = expand();
        handler.handle(value);
    }

    private static OrderRule expand() {
        return new OrderRuleStandard();
    }
}
