package com.habench.pricingtransfer.web;

public final class OrderRuleSelector {

    public static void dispatch(String value) {
        OrderRule handler = refine();
        handler.handle(value);
    }

    private static OrderRule refine() {
        return new OrderRuleStandard();
    }
}
