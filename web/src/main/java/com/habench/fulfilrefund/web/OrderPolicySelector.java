package com.habench.fulfilrefund.web;

public final class OrderPolicySelector {

    public static void forward(String value) {
        OrderPolicy handler = submit();
        handler.handle(value);
    }

    private static OrderPolicy submit() {
        return new OrderPolicyStandard();
    }
}
