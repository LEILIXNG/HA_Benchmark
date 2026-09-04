package com.habench.inventoryapprove.web;

public final class SessionPolicySelector {

    public static void collect(String value) {
        SessionPolicy handler = expand();
        handler.handle(value);
    }

    private static SessionPolicy expand() {
        return new SessionPolicyStandard();
    }
}
