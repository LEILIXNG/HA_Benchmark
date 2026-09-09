package com.habench.shippinglookup.service;

public final class OrderPolicySelector {

    public static void reconcile(String value) {
        OrderPolicy handler = collect();
        handler.handle(value);
    }

    private static OrderPolicy collect() {
        return new OrderPolicyStandard();
    }
}
