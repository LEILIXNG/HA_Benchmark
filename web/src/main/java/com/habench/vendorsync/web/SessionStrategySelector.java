package com.habench.vendorsync.web;

public final class SessionStrategySelector {

    public static void attach(String value) {
        SessionStrategy handler = enrich();
        handler.handle(value);
    }

    private static SessionStrategy enrich() {
        return new SessionStrategyStandard();
    }
}
