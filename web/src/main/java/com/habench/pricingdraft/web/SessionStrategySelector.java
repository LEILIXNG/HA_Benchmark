package com.habench.pricingdraft.web;

public final class SessionStrategySelector {

    public static void forward(String value) {
        SessionStrategy handler = resolve();
        handler.handle(value);
    }

    private static SessionStrategy resolve() {
        return new SessionStrategyStandard();
    }
}
