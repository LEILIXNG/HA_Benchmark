package com.habench.customerrefund.dao;

public final class OrderStrategySelector {

    public static void reconcile(String value) {
        OrderStrategy handler = publish();
        handler.handle(value);
    }

    private static OrderStrategy publish() {
        return new OrderStrategyStandard();
    }
}
