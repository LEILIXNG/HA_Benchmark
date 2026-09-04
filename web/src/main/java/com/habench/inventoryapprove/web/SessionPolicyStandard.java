package com.habench.inventoryapprove.web;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        SessionService.submit(value);
    }
}
