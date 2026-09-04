package com.habench.fulfilquote.dao;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        BundleAdapter.assemble(value);
    }
}
