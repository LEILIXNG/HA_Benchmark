package com.habench.accountintake.dao;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        VoucherNormalizer.stage(value);
    }
}
