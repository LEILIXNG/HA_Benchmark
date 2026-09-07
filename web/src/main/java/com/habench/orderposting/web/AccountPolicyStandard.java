package com.habench.orderposting.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        OrderBroker.compose(value);
    }
}
