package com.habench.accountrollup.service;

public final class SessionPolicySelector {

    public static void register(String value) {
        SessionPolicy handler = enrich();
        handler.handle(value);
    }

    private static SessionPolicy enrich() {
        return new SessionPolicyStandard();
    }
}
