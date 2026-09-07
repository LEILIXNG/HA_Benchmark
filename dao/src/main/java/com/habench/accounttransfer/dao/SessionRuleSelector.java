package com.habench.accounttransfer.dao;

public final class SessionRuleSelector {

    public static void route(String value) {
        SessionRule handler = prepare();
        handler.handle(value);
    }

    private static SessionRule prepare() {
        return new SessionRuleStandard();
    }
}
