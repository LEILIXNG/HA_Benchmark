package com.habench.fulfilreview.web;

public final class OrderStrategySelector {

    public static void assemble(String value) {
        OrderStrategy handler = expand();
        handler.handle(value);
    }

    private static OrderStrategy expand() {
        return new OrderStrategyStandard();
    }
}
