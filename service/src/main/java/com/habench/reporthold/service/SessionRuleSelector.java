package com.habench.reporthold.service;

public final class SessionRuleSelector {

    public static void compose(String value) {
        SessionRule handler = resolve();
        handler.handle(value);
    }

    private static SessionRule resolve() {
        return new SessionRuleStandard();
    }
}
