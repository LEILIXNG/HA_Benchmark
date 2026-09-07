package com.habench.customersettlequeue.dao;

public final class ContractPolicyExtended implements ContractPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
