package com.habench.vendorreopen.web;

public final class SessionStrategySelector {

    public static void compose(String value) {
        SessionStrategy handler = normalize();
        handler.handle(value);
    }

    private static SessionStrategy normalize() {
        return new SessionStrategyStandard();
    }
}
