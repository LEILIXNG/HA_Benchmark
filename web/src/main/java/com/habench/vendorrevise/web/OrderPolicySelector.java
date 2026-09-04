package com.habench.vendorrevise.web;

public final class OrderPolicySelector {

    public static void dispatch(String value) {
        OrderPolicy handler = translate();
        handler.handle(value);
    }

    private static OrderPolicy translate() {
        return new OrderPolicyStandard();
    }
}
