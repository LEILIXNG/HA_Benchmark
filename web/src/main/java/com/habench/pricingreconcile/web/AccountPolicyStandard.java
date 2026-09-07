package com.habench.pricingreconcile.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        BatchAssembler.expand(value);
    }
}
