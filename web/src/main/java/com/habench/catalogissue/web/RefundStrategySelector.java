package com.habench.catalogissue.web;

public final class RefundStrategySelector {

    public static void enrich(String value) {
        RefundStrategy handler = route();
        handler.handle(value);
    }

    private static RefundStrategy route() {
        return new RefundStrategyStandard();
    }
}
