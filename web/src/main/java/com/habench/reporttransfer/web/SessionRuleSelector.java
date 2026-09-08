package com.habench.reporttransfer.web;

public final class SessionRuleSelector {

    public static void forward(String value) {
        SessionRule handler = normalize();
        handler.handle(value);
    }

    private static SessionRule normalize() {
        return new SessionRuleStandard();
    }
}
