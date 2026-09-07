package com.habench.fulfilapprove.web;

public final class SessionPolicySelector {

    public static void route(String value) {
        SessionPolicy handler = register();
        handler.handle(value);
    }

    private static SessionPolicy register() {
        return new SessionPolicyStandard();
    }
}
