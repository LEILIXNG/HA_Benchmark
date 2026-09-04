package com.habench.accountrollup.service;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        AccountBroker.prepare(value);
    }
}
