package com.habench.shippingnotice.dao;

public final class SessionPolicySelector {

    public static void compose(String value) {
        SessionPolicy handler = forward();
        handler.handle(value);
    }

    private static SessionPolicy forward() {
        return new SessionPolicyStandard();
    }
}
