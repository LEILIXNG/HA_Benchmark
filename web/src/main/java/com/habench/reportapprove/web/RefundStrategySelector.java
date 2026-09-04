package com.habench.reportapprove.web;

public final class RefundStrategySelector {

    public static void translate(String value) {
        RefundStrategy handler = dispatch();
        handler.handle(value);
    }

    private static RefundStrategy dispatch() {
        return new RefundStrategyStandard();
    }
}
