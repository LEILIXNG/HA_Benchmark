package com.habench.vendorsync.service;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        SessionService.attach(value);
    }
}
