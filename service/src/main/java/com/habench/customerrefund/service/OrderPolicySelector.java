package com.habench.customerrefund.service;

public final class OrderPolicySelector {

    public static void forward(String value) {
        OrderPolicy handler = expand();
        handler.handle(value);
    }

    private static OrderPolicy expand() {
        return new OrderPolicyStandard();
    }
}
