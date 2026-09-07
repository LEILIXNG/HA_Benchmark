package com.habench.vendordraft.dao;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        InvoiceBroker.resolve(value);
    }
}
