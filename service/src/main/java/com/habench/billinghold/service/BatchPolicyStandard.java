package com.habench.billinghold.service;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        ContractRouter.attach(value);
    }
}
