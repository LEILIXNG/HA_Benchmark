package com.habench.orderarchive.service;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ReceiptCoordinator.collect(value);
    }
}
