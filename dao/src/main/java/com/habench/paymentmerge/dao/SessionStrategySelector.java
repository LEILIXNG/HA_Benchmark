package com.habench.paymentmerge.dao;

public final class SessionStrategySelector {

    public static void expand(String value) {
        SessionStrategy handler = normalize();
        handler.handle(value);
    }

    private static SessionStrategy normalize() {
        return new SessionStrategyStandard();
    }
}
