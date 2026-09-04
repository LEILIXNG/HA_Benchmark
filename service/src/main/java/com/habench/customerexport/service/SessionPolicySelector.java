package com.habench.customerexport.service;

public final class SessionPolicySelector {

    public static void translate(String value) {
        SessionPolicy handler = submit();
        handler.handle(value);
    }

    private static SessionPolicy submit() {
        return new SessionPolicyStandard();
    }
}
