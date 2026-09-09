package com.habench.paymentbatch.service;

public final class SessionPolicySelector {

    public static void enrich(String value) {
        SessionPolicy handler = compose();
        handler.handle(value);
    }

    private static SessionPolicy compose() {
        return new SessionPolicyStandard();
    }
}
