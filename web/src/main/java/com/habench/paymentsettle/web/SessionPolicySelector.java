package com.habench.paymentsettle.web;

public final class SessionPolicySelector {

    public static void forward(String value) {
        SessionPolicy handler = attach();
        handler.handle(value);
    }

    private static SessionPolicy attach() {
        return new SessionPolicyStandard();
    }
}
