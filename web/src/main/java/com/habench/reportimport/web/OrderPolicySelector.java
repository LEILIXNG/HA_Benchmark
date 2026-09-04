package com.habench.reportimport.web;

public final class OrderPolicySelector {

    public static void forward(String value) {
        OrderPolicy handler = attach();
        handler.handle(value);
    }

    private static OrderPolicy attach() {
        return new OrderPolicyStandard();
    }
}
