package com.habench.vendorreopen.service;

public final class SessionStrategySelector {

    public static void resolve(String value) {
        SessionStrategy handler = assemble();
        handler.handle(value);
    }

    private static SessionStrategy assemble() {
        return new SessionStrategyStandard();
    }
}
