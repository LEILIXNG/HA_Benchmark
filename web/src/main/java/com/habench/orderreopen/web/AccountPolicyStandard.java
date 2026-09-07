package com.habench.orderreopen.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ManifestRouter.route(value);
    }
}
