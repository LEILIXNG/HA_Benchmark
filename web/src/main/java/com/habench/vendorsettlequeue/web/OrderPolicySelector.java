package com.habench.vendorsettlequeue.web;

public final class OrderPolicySelector {

    public static void route(String value) {
        OrderPolicy handler = publish();
        handler.handle(value);
    }

    private static OrderPolicy publish() {
        return new OrderPolicyStandard();
    }
}
