package com.habench.orderrefund.service;

public final class SessionPolicySelector {

    public static void forward(String value) {
        SessionPolicy handler = dispatch();
        handler.handle(value);
    }

    private static SessionPolicy dispatch() {
        return new SessionPolicyStandard();
    }
}
