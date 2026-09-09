package com.habench.ordersync.web;

public final class BatchRuleSelector {

    public static void publish(String value) {
        BatchRule handler = expand();
        handler.handle(value);
    }

    private static BatchRule expand() {
        return new BatchRuleStandard();
    }
}
