package com.habench.fulfilapprove.web;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        QuoteBroker.prepare(value);
    }
}
